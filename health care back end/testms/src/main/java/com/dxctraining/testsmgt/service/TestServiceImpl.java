package com.dxctraining.testsmgt.service;

import com.dxctraining.testsmgt.exceptions.TestNotFoundException;
import com.dxctraining.testsmgt.entities.Test;
import com.dxctraining.testsmgt.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// transactional will inform spring that it has to open transaction at every method in this class
@Transactional
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private com.dxctraining.testsmgt.dao.ITestDao dao;

    @Override
    public Test findTestById(int id) {
        Optional<Test> optional = dao.findById(id);
        if (!optional.isPresent()) {
            throw new TestNotFoundException("test not found for id=" + id);
        }
        Test test = optional.get();
        return test;
    }


    @Override
    public Test save(Test test) {
        validateTest(test);
        test = dao.save(test);
        return test;
    }

    @Override
    public void remove(int id) {
        dao.deleteById(id);
    }

    public void validateTest(Object arg) {
        if (arg == null) {
            throw new InvalidArgumentException("argument is null");
        }
    }

    @Override
    public Test findByName(String name) {
        Test test = dao.findByName(name);
        return test;
    }


    @Override
    public List<Test> allTest() {
        List<Test> test = dao.findAll();
        return test;
    }

    @Override
    public List<Test> findByCenterId(String centerId) {
        List<Test> tests = dao.findByCenterId(centerId);
        return tests;
    }

}
