package com.dxctraining.healthcaresystem.service;

import java.util.List;

import com.dxctraining.healthcaresystem.entities.DiagnosticCenter;
import com.dxctraining.healthcaresystem.exception.CenterAlreadyExistsException;
import com.dxctraining.healthcaresystem.exception.CenterNameAlreadyExistsException;
import com.dxctraining.healthcaresystem.exception.NoCentersAreAvailableException;
import com.dxctraining.healthcaresystem.exception.SpecifiedCenterDoesnotExistException;


public interface IDiagnosticCenterService {

    DiagnosticCenter addCenter(DiagnosticCenter center);

    List<DiagnosticCenter> getAllCenters() ;

    DiagnosticCenter getCenterById(String centerId) ;

    boolean removeCenter(String centerId) ;


}
