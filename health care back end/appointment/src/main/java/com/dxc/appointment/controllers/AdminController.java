package com.dxc.appointment.controllers;

import com.dxc.appointment.dto.AppointmentDetails;
import com.dxc.appointment.entities.Appointment;
import com.dxc.appointment.service.IAppointmentService;
import com.dxc.appointment.util.AppointmentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/appointments/")
@RestController
public class AdminController {

    @Autowired
    private IAppointmentService service;

    @Autowired
    private AppointmentUtil appointmentUtil;

    @PutMapping("/{id}/approve")
    public AppointmentDetails approveAppointment(@PathVariable("id") Integer id) {
        Appointment appointment = service.findAppointmentById(id);
        appointment=service.approveAppointment(appointment);
        AppointmentDetails details = appointmentUtil.appointmentDetails(appointment);
        return details;
    }


    @GetMapping("/by/centerid/{centerId}")
    public List<AppointmentDetails> getAppointmentsByCenterId(@PathVariable("centerId") String centerId){
        List<Appointment>appointments= service.findAppointmentsByCenterId(centerId);
        List<AppointmentDetails>details=appointmentUtil.appointmentDetailsList(appointments);
        return details;
    }
}
