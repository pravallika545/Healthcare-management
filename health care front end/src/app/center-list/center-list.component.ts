import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { observable, Observable } from 'rxjs';
import { AuthenticationService } from '../authservice';
import { Center } from '../model/center';
import { CenterService } from '../service/center.service';

@Component({
  selector: 'center-list',
  templateUrl: './center-list.component.html',
  styleUrls: ['./center-list.component.css']
})
export class CenterListComponent  implements OnInit{
  
  centers:Center[];

  errMsg:string;


  constructor(private centerService:CenterService, private authService:AuthenticationService, private router:Router) {
   
   }

  ngOnInit(): void {
    if(!this.authService.isAuthenticated()){
       this.router.navigate(['login']);
    }
    let observable:Observable<Center[]>=this.centerService.getAll();
    observable.subscribe(
      (centersArg:Center[])=>{this.centers=centersArg;
      console.log("received centers="+this.centers);
     },
       err=>{
         this.errMsg=err.message;
         if(err.status==401){
          this.errMsg="You are not authorized";
         }
         
       }
     
    )
  }

     deleteCenter(centerid:number){
    let observable=this.centerService.removeCenter(centerid);
    observable.subscribe(
      res=>{
       this.removeLocalElement(centerid);
      },
      err=>{
        console.log("inside removeuser, err is "+err.message);
        this.errMsg=err.message;
      }
      );
    }

   removeLocalElement(centerId: number): void {
    console.log("before center removed,length=" + this.centers.length);
    for (let i = 0; i < this.centers.length; i++) {
      let center = this.centers[i];
      if (center.centerId === centerId) {
        //index and number of elements to remove
        this.centers.splice(i, 1);
      }
    }

  }

}
