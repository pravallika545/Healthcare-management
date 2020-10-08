import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../authservice';
import { Center } from '../model/center';
import { CenterService } from '../service/center.service';

@Component({
  selector: 'add-center',
  templateUrl: './add-center.component.html',
  styleUrls: ['./add-center.component.css']
})
export class AddCenterComponent implements OnInit{
  center:Center;
  errMsg:string

  constructor(private centerService:CenterService, private authService:AuthenticationService, private router:Router){
  }
  
 
 
  ngOnInit(): void {
    if(!this.authService.isAuthenticated()){
      this.router.navigate(['login']);
   }
  }
  addCenter(form:any){
   let data=form.value;
   let name=data.centername;
   this.center = new Center(-1, name);
   let successFun = (centerArg: Center) => {
    this.center = centerArg;
  };
 
  let errFun =  err=>{
    if(err.status==401){
     this.errMsg="You are not authorized";
    }
    
  }


  let observable: Observable<Center> = this.centerService.addCenter(this.center);
  observable.subscribe(successFun, errFun);
 
  }

}