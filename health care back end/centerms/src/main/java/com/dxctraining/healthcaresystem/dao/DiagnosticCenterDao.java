package com.dxctraining.healthcaresystem.dao;

import javax.transaction.Transactional;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxctraining.healthcaresystem.entities.DiagnosticCenter;



@Repository
@Transactional
public interface DiagnosticCenterDao extends JpaRepository<DiagnosticCenter, String> {

}
