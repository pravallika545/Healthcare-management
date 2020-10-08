import { Component, OnInit, Injectable } from '@angular/core';
import { AuthenticationService } from '../authservice';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.css']
})

export class AuthenticateComponent implements OnInit {

  service:AuthenticationService;
  router:Router;
  constructor(service:AuthenticationService,router: Router) {
    this.service=service;
    this.router=router;
   }

  ngOnInit(): void {
  }


  loginSubmit(form:any){
// let data  = form.values;
let data=form.value;
let username=data.username;
let password=data.password;
 let observable:Observable<any>=this.service.loginRequest(username,password);
 observable.subscribe(
   token=>{
     this.service.saveDetailsOnLoginSuccess(data, token);
     this.router.navigate(['app-home']);
   },
   err=>{
   //  console.log("err while fetching token="+err.message);
     let text=JSON.stringify(err);
     console.log("err is "+text);
   }
 );
}

}
