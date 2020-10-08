import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';
import { AppointmentService } from '../service/appointmentservice';

@Component({
  selector: 'make-appointment',
  templateUrl: './make-appointment.component.html',
  styleUrls: ['./make-appointment.component.css']
})
export class MakeAppointmentComponent implements OnInit {

  constructor(private service:AppointmentService) {

   }
   appointment:Appointment;
   makeAppointment(form:any) {
     let data =form.value;
     let userId =data.userId;
     let testId = data.testId;
     let dateTime =data.dateTime;
     let approved =data.approved;
     let centerId =data.centerId;
     this.appointment=new Appointment(1,userId,testId,dateTime,approved,centerId);
     let observable:Observable<Appointment>=this.service.makeAppointment(this.appointment);
     observable.subscribe(appointmentarg=>{this.appointment=appointmentarg});

   }
  

  ngOnInit(): void {
  }

}
