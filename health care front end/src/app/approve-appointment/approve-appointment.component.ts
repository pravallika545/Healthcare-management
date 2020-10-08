import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';
import { AppointmentService } from '../service/appointmentservice';

@Component({
  selector: 'approve-appointment',
  templateUrl: './approve-appointment.component.html',
  styleUrls: ['./approve-appointment.component.css']
})
export class ApproveAppointmentComponent implements OnInit {

  constructor(private service:AppointmentService) {

   }

   appointment:Appointment;
   approveAppointment(form:any) {
     let data=form.value;
     let appointmentId=data.appointmentId;
     let observable:Observable<Appointment>=this.service.approveAppointment(appointmentId);
     observable.subscribe(appointmentarg=>{this.appointment=appointmentarg});
     
   }





  ngOnInit(): void {
  }

}
