package com.dxctraining.usermgt.controller;

import com.dxctraining.usermgt.dto.AddUserRequestData;
import com.dxctraining.usermgt.entities.User;
import com.dxctraining.usermgt.exceptions.UnAuthorizedException;
import com.dxctraining.usermgt.service.IUserService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/users")
public class UsersController {
    private static final Logger Log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private IUserService service;


    /**
     *
     * Case when only user can fetch his information, not of any other user
     * Admin can fetch information of other users too
     */
    @GetMapping("/by/id/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int id, HttpServletRequest request) {
        String requestSenderUsername= request.getHeader("requestsender");
        User requestSender=service.findByUsername(requestSenderUsername);
        if(requestSender.getId()==id || "admin".equals(requestSender.getRole()))  {
            User desiredUser=service.findById(id);
            ResponseEntity<User> response = new ResponseEntity<>(desiredUser, HttpStatus.OK);
            return response;
        }
        throw new UnAuthorizedException("you are not authorized");
    }


    /**
     *
     * Case when only user can fetch his information, not of any other user
     * Admin can fetch information of other users too
     */
    @GetMapping("/by/username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable("username") String username, HttpServletRequest request) {
        String requestSenderUsername= request.getHeader("requestsender");
        User requestSender=service.findByUsername(requestSenderUsername);
        if(requestSenderUsername.equals(username) || "admin".equals(requestSender.getRole()))  {
            User desiredUser=service.findByUsername(username);
            ResponseEntity<User> response = new ResponseEntity<>(desiredUser, HttpStatus.OK);
            return response;
        }
        throw new UnAuthorizedException("you are not authorized");
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequestData requestData) {
        User user = convert(requestData);
        user =service.save(user);
        ResponseEntity<User> response = new ResponseEntity<>(user, HttpStatus.OK);
        return response;
    }

    public User convert(AddUserRequestData dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return user;
    }

}
