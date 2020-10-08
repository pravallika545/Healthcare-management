import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Appointment } from '../model/appointment';
import { Observable } from 'rxjs';
@Injectable()
export class AppointmentService{
    baseurl = "http://localhost:8590/user/appointments";
    basicurl = "http://localhost:8590/admin/appointments";
    constructor(private http:HttpClient) {

    }
    makeAppointment(appointment:Appointment):Observable<Appointment>{
        let url =this.baseurl+"/add";
        let observable:Observable<Appointment> =this.http.post<Appointment>(url,appointment);
        return observable;
    }


    getAppointment(appointmentId:number):Observable<Appointment>{
        let url = this.baseurl+"/byid/"+appointmentId;
        let observable:Observable<Appointment> =this.http.get<Appointment>(url);
        return observable;
    }
    getAppointmentsByCenterId(centerId:string):Observable<Appointment>{
        let url = this.baseurl+"/bycenterid/"+centerId;
        let observable:Observable<Appointment> =this.http.get<Appointment>(url);
        return observable;
    }
    getAppointmentsBytestId(testId:number):Observable<Appointment>{
        let url = this.baseurl+"/bytestid/"+testId;
        let observable:Observable<Appointment> =this.http.get<Appointment>(url);
        return observable;
    }

    removeAppointment(appointmentId:number):Observable<Appointment>{
        let url = this.baseurl+"/remove/"+appointmentId;
        let observable:Observable<Appointment> =this.http.delete<Appointment>(url);
        return observable;
    }

    approveAppointment(appointmentId:number):Observable<Appointment> {
        let url = this.basicurl+"/approve/"+appointmentId;
        let observable:Observable<Appointment> =this.http.put<Appointment>(url,appointmentId);
        return observable;
    }
}
