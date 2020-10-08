package com.dxc.gateway.controller;

import com.dxc.gateway.dto.CreateUserRequest;
import com.dxc.gateway.dto.CreateTokenRequest;
import com.dxc.gateway.dto.UserDetails;
import com.dxc.gateway.entities.UserCredential;
import com.dxc.gateway.exceptions.IncorrectCredentialsException;
import com.dxc.gateway.service.CredentialService;
import com.dxc.gateway.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@Validated
public class GateController {
    private static final Logger Log = LoggerFactory.getLogger(GateController.class);

    @Value("${userservice.baseurl}")
    private String userServiceBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CredentialService service;

    @PostMapping("/register")
    public ResponseEntity<UserDetails> register(@RequestBody @Valid CreateUserRequest requestData) {
        System.out.println("****pass "+requestData.getPassword() +" role="+requestData.getRole()+" username="+requestData.getUsername());
        String url = userServiceBaseUrl + "/add";
        UserDetails createCustomer = restTemplate.postForObject(url, requestData, UserDetails.class);
        UserCredential credential = new UserCredential();
        credential.setPassword(createCustomer.getPassword());
        credential.setRole(requestData.getRole());
        credential.setUsername(createCustomer.getUsername());
        System.out.println("*** cred entity "+credential.getUsername()+" "+credential.getPassword()+" "+credential.getRole());
        credential=service.save(credential);
        ResponseEntity<UserDetails> response = new ResponseEntity<>(createCustomer, HttpStatus.OK);
        return response;
    }

    @PostMapping("/createtoken")
    public ResponseEntity<String> createToken(@RequestBody @Valid CreateTokenRequest requestData) {
        String username = requestData.getUsername();
        String password = requestData.getPassword();
        boolean correct = service.checkCredentials(username, password);
        if (!correct) {
            throw new IncorrectCredentialsException("incorrect credentials");
        }
        UserCredential credential =service.findByUsername(username);
        String role=credential.getRole();
        String token = TokenUtil.generateToken(username, password,role);
        ResponseEntity<String> response = new ResponseEntity<>(token, HttpStatus.OK);
        return response;
    }


}
