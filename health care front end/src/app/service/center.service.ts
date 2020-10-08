import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Center } from '../model/center';

@Injectable({
  providedIn: 'root'
})
export class CenterService{
urlPath="http://localhost:8590/admin/centers";

constructor(private http:HttpClient){

}

addCenter(center:Center):Observable<Center>{
    let url=this.urlPath+"/add";
    let observable:Observable<Center>=this.http.post<Center>(url,center);
    return observable;
}

getCenter(centerId:number):Observable<Center>{
    let url=this.urlPath+"/get/"+centerId;
    let observable:Observable<Center>=this.http.get<Center>(url);
    return observable;
}

getAll():Observable<Center[]>{
    let url=this.urlPath;
    let observable:Observable<Center[]>=this.http.get<Center[]>(url);
    return observable;
}

removeCenter(centerId:number):Observable<Center[]>{
    let url=this.urlPath+"/remove/"+centerId;
    let observable:Observable<Center[]>=this.http.delete<Center[]>(url);
    return observable;
}

}
