package com.dxctraining.healthcaresystem.util;

import com.dxctraining.healthcaresystem.dto.AppointmentDetails;
import com.dxctraining.healthcaresystem.dto.DiagnosticCenterDetails;
import com.dxctraining.healthcaresystem.dto.TestDetails;
import com.dxctraining.healthcaresystem.entities.DiagnosticCenter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CenterUtil {

    public DiagnosticCenterDetails details(DiagnosticCenter center, List<TestDetails>tests, List<AppointmentDetails>appointments){
        DiagnosticCenterDetails centerDetails=new DiagnosticCenterDetails();
        centerDetails.setTests(tests);
        centerDetails.setCenterId(center.getCenterId());
        centerDetails.setCenterName(center.getCenterName());
        centerDetails.setAppointments(appointments);
        return centerDetails;
    }

}
