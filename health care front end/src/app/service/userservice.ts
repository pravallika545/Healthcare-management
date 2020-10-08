import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { AuthenticationService } from '../authservice';
import { User } from '../model/user';

@Injectable()
export class UserService{
    client:HttpClient;
    authService:AuthenticationService;

    baseServiceUrl="http://localhost:8590/users/";
 
    constructor(client:HttpClient,authService:AuthenticationService){
    this.client=client;
    this.authService=authService;
     }
 

    fetchMe():Observable<User>{
     let username=this.authService.getLoginUsername()
     if(username==""|| username==undefined|| username==null){
         return;
     }
     let url=this.baseServiceUrl+"/by/username/"+username;  
     let observable:Observable<User>=this.client.get<User>(url);
     return observable;
    }

    addUser(user:User){
        let registerUrl="http://localhost:8590/register";
        user.role="user";
        let observable:Observable<User>=this.client.post<User>(registerUrl,user);
        return observable;

    }


}