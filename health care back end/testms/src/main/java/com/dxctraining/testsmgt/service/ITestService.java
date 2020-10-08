package com.dxctraining.testsmgt.service;


import com.dxctraining.testsmgt.entities.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITestService {

    Test findTestById(int id);

    Test save(Test test);

    void remove(int id);

    Test findByName(String name);

    List<Test> allTest();

    List<Test> findByCenterId(String centerId);
}
