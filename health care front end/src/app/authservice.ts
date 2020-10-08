import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthenticationService{

     client:HttpClient;

   baseServiceUrl="http://localhost:8590";
   constructor(client:HttpClient){
  this.client=client;
    }

loginRequest(username:string,password:string):Observable<string>{
 let url=this.baseServiceUrl+"/createtoken";   
 let cred={username,password}; 
 let observable:Observable<string> =this.client.post(url,cred,{responseType:"text"});
 return observable;
}

saveDetailsOnLoginSuccess(data,token){
  let username=data["username"];
  localStorage.setItem("token",token);
  localStorage.setItem("username",username);
}

isAuthenticated(){
  let token=localStorage.getItem("token");
  if(token==null || token==undefined ){
   return false;
  }
  return true;
}


getLoginUsername(){
  let username= localStorage.getItem("username");
  return username;
}

logout(){
localStorage.removeItem("token")
localStorage.removeItem("username");
localStorage.removeItem("id");
}

}