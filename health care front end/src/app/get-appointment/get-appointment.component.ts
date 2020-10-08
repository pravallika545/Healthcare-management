import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';
import { AppointmentService } from '../service/appointmentservice';

@Component({
  selector: 'get-appointment',
  templateUrl: './get-appointment.component.html',
  styleUrls: ['./get-appointment.component.css']
})
export class GetAppointmentComponent implements OnInit {

  constructor(private service:AppointmentService) {

   }
   
   appointment:Appointment;
   getAppointment(form:any) {
     let data=form.value;
     
     let appointmentId=data.appointmentId;
     let observable:Observable<Appointment>=this.service.getAppointment(appointmentId);
     observable.subscribe(appointmentarg=>{this.appointment=appointmentarg});

   }

   getAppointmentsByCenterId(form:any) {
     let data =form.value;
     let centerId=data.centerId;
     let observable:Observable<Appointment>=this.service.getAppointmentsByCenterId(centerId);
     observable.subscribe(appointmentarg=>{this.appointment=appointmentarg});

   }
   getAppointmentsBytestId(testId:number) {
     let observable:Observable<Appointment>=this.service.getAppointmentsBytestId(testId);
     observable.subscribe(appointmentarg=>{this.appointment=appointmentarg});
     
   }
    
   removeAppointment(appointmentId:number) {
    let observable:Observable<Appointment>=this.service.removeAppointment(appointmentId);
    observable.subscribe(appointmentarg=>{this.appointment=appointmentarg});
  
   }


  ngOnInit(): void {
  }

}
