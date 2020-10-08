package com.dxctraining.healthcaresystem.dto;

import java.util.List;

public class DiagnosticCenterDetails {
    private String centerId;
    private String centerName;
    private List<TestDetails>tests;

    private List<AppointmentDetails>appointments;

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public List<TestDetails> getTests() {
        return tests;
    }

    public void setTests(List<TestDetails> tests) {
        this.tests = tests;
    }

    public List<AppointmentDetails> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentDetails> appointments) {
        this.appointments = appointments;
    }
}
