package com.dxctraining.healthcaresystem;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dxctraining.healthcaresystem.entities.DiagnosticCenter;
import com.dxctraining.healthcaresystem.exception.CenterNameAlreadyExistsException;
import com.dxctraining.healthcaresystem.exception.SpecifiedCenterDoesnotExistException;
import com.dxctraining.healthcaresystem.service.IDiagnosticCenterService;

@SpringBootTest
class DiagnosticCenterManagementApplicationTests {

	
	@Autowired
	private IDiagnosticCenterService diagnostic;
	
	
	@Test
	public void centerByIdTest() throws SpecifiedCenterDoesnotExistException
	{
		
	DiagnosticCenter c = diagnostic.getCenterById("1234567");
	assertEquals("1234567",c.getCenterId());
	
		
	}
	
	
	@Test
	public void testCenterByIdException() {
		 
		 Assertions.assertThrows(SpecifiedCenterDoesnotExistException.class, () -> {
		      diagnostic.getCenterById("1");
		    });
	} 
	
	
	
	

}
