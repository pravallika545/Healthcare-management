package com.dxctraining.healthcaresystem.service;

import java.util.List;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.healthcaresystem.dao.DiagnosticCenterDao;
import com.dxctraining.healthcaresystem.entities.DiagnosticCenter;
import com.dxctraining.healthcaresystem.exception.CenterAlreadyExistsException;
import com.dxctraining.healthcaresystem.exception.CenterNameAlreadyExistsException;
import com.dxctraining.healthcaresystem.exception.NoCentersAreAvailableException;
import com.dxctraining.healthcaresystem.exception.SpecifiedCenterDoesnotExistException;


@Service
public class DiagnosticCenterServiceImplementation implements IDiagnosticCenterService {


    @Autowired
    private DiagnosticCenterDao repository;

    @Override
    public DiagnosticCenter getCenterById(String centerId) {
        boolean existingCenter = repository.existsById(centerId);
        if (!existingCenter) {
            throw new SpecifiedCenterDoesnotExistException("Center with center id " + centerId + "Doesnot exist");
        }
        DiagnosticCenter center = repository.getOne(centerId);
        return center;
    }

    @Override
    public List<DiagnosticCenter> getAllCenters() {

        List<DiagnosticCenter> centerList = repository.findAll();

        if (centerList.isEmpty()) {
            throw new NoCentersAreAvailableException("No center is present");
        }

        return centerList;
    }

    @Override
    public DiagnosticCenter addCenter(DiagnosticCenter center) {
        String id = generateId();
        center.setCenterId(id);
        if (repository.existsById(center.getCenterId())) {
            throw new CenterAlreadyExistsException("Center already exists kindly enter another center ID");
        }


        return repository.save(center);

    }


    @Override
    public boolean removeCenter(String centerId) {
        DiagnosticCenter center = getCenterById(centerId);
        repository.delete(center);
        return true;
    }

    public String generateId() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(99);
            builder.append(number);
        }
        return builder.toString();
    }


}