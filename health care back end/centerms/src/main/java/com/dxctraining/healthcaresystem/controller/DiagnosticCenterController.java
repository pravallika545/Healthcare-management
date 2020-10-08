package com.dxctraining.healthcaresystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.dxctraining.healthcaresystem.dto.AppointmentDetails;
import com.dxctraining.healthcaresystem.dto.CreateCenterRequest;
import com.dxctraining.healthcaresystem.dto.DiagnosticCenterDetails;
import com.dxctraining.healthcaresystem.dto.TestDetails;
import com.dxctraining.healthcaresystem.util.CenterUtil;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.healthcaresystem.entities.DiagnosticCenter;
import com.dxctraining.healthcaresystem.exception.CenterAlreadyExistsException;
import com.dxctraining.healthcaresystem.exception.CenterNameAlreadyExistsException;
import com.dxctraining.healthcaresystem.exception.NoCentersAreAvailableException;
import com.dxctraining.healthcaresystem.exception.SpecifiedCenterDoesnotExistException;
import com.dxctraining.healthcaresystem.service.DiagnosticCenterServiceImplementation;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/admin/centers")
public class DiagnosticCenterController {
    @Autowired
    private DiagnosticCenterServiceImplementation centerService;

    @Autowired
    private RestTemplate template;

    @Autowired
    private CenterUtil centerUtil;

    @GetMapping("/get/{centerId}")
    public DiagnosticCenterDetails getCenterById(@PathVariable("centerId") String centerId) {
        DiagnosticCenter center= centerService.getCenterById(centerId);
        List<AppointmentDetails>appointments=fetchAppointmentsByCenterId(centerId);
        List<TestDetails>tests=fetchTestsByCenterId(centerId);
        DiagnosticCenterDetails details=centerUtil.details(center,tests,appointments);
        return details;
    }


    @PostMapping("/add")
    public DiagnosticCenterDetails addCenter(@RequestBody CreateCenterRequest request) {
        DiagnosticCenter center=new DiagnosticCenter();
        center.setCenterName(request.getCenterName());
        center=centerService.addCenter(center);
        //at start tests and appointments are empty
        DiagnosticCenterDetails response=centerUtil.details(center,new ArrayList<>(),new ArrayList<>());
        return response;
    }

    @GetMapping
    public List<DiagnosticCenterDetails>getAllCenters(){
       List<DiagnosticCenter>centers= centerService.getAllCenters();
       List<DiagnosticCenterDetails>response=new ArrayList<>();
       for (DiagnosticCenter center:centers){
           List<AppointmentDetails>appointments=fetchAppointmentsByCenterId(center.getCenterId());
           List<TestDetails>tests=fetchTestsByCenterId(center.getCenterId());
           DiagnosticCenterDetails details=centerUtil.details(center,tests,appointments);
           response.add(details);
       }
       return  response;
    }

    @DeleteMapping("/remove/{centerId}")
    public boolean removeCenter(@PathVariable String centerId) {
        return centerService.removeCenter(centerId);
    }


    public List<TestDetails> fetchTestsByCenterId(String centerId) {
        String url = "http://test-ms/admin/tests/by/centerid/" + centerId;
        TestDetails[] tests=template.getForObject(url,TestDetails[].class);
        List<TestDetails>list=Arrays.stream(tests).collect(Collectors.toList());
        return list;
    }

    public List<AppointmentDetails>fetchAppointmentsByCenterId(String centerId){
        String url="http://appointment-ms/admin/appointments/by/centerid/"+centerId;
        AppointmentDetails appointments[]=template.getForObject(url,AppointmentDetails[].class);
        List<AppointmentDetails>list=Arrays.asList(appointments);
        return list;
    }


}