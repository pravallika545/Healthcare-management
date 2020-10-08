package com.dxctraining.healthcaresystem.entities;

import java.math.BigInteger;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "center")
public class DiagnosticCenter {

    @Id
    private String centerId;
    private String centerName;

    public DiagnosticCenter() {
    }

    public DiagnosticCenter(String centerId, String centerName) {
        this.centerId = centerId;
        this.centerName = centerName;
    }

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


}