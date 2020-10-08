package com.dxctraining.testsmgt.controller;


import com.dxctraining.testsmgt.dto.CreateTestRequest;
import com.dxctraining.testsmgt.dto.TestDto;
import com.dxctraining.testsmgt.entities.Test;
import com.dxctraining.testsmgt.service.ITestService;
import com.dxctraining.testsmgt.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Validated
@RestController
@RequestMapping("/admin/tests")
public class TestRestController {

    @Autowired
    private TestUtil testUtil;

    @Autowired
    private ITestService testService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public TestDto create(@RequestBody CreateTestRequest data) {
        Test test = new Test(data.getCenterId(),data.getName());
        test = testService.save(test);
        TestDto response = testUtil.toDto(test);
        return response;
    }

    @GetMapping("/by/id/{id}")
    public TestDto findTest(@PathVariable("id") int id) {
        Test test = testService.findTestById(id);
        TestDto dto = testUtil.toDto(test);
        return dto;
    }


    @GetMapping("/by/name/{name}")
    public TestDto findByName(@PathVariable("name") String name) {
        Test test = testService.findByName(name);
        TestDto dto = testUtil.toDto(test);
        return dto;

    }

    @GetMapping
    public List<TestDto> findall() {
        List<Test> test = testService.allTest();
        List<TestDto> result = new ArrayList<>();
        for (Test ar : test) {
            TestDto dto = testUtil.toDto(ar);
            result.add(dto);
        }
        return result;

    }

    @DeleteMapping("/delete/{id}")
    public void deleteTestById(@PathVariable("id") Integer id) {
        testService.remove(id);
    }

    @GetMapping("/by/centerid/{centerid}")
    public List<TestDto> findByCenterId(@PathVariable("centerid") String centerId) {
        List<Test> tests = testService.findByCenterId(centerId);
        List<TestDto> response = testUtil.testDtos(tests);
        return response;
    }


}

