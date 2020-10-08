package com.dxctraining.testsmgt.dao;

import com.dxctraining.testsmgt.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ITestDao extends JpaRepository<Test, Integer> {
    Test findByName(String name);

    List<Test> findByCenterId(String centerId);
}
