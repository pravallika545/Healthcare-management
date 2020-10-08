import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../authservice';
import { Center } from '../model/center';
import { CenterService } from '../service/center.service';

@Component({
  selector: 'center-details',
  templateUrl: './center-details.component.html',
  styleUrls: ['./center-details.component.css']
})
export class CenterDetailsComponent implements OnInit{

  constructor(private route:ActivatedRoute, private centerService:CenterService, private authService:AuthenticationService, private router:Router) {
   }
   
  ngOnInit(): void {
    if(!this.authService.isAuthenticated()){
      this.router.navigate(['login']);
   }
  }

  center:Center;

  findCenterById(idform){
    let data=idform.value;
    console.log("data="+data);
    let centerId=data.centerid;
    let observable:Observable<Center>=this.centerService.getCenter(centerId);
    observable.subscribe(
      centerArg=>{
        this.center=centerArg;
        console.log("response fetched="+this.center.centerName);
      }
    )
  
  }
   findCenter(form:any){
     let data=form.value;
    let id=data.centerId;
     this.findCenterById(id);
   }

}
