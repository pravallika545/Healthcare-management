import { Component, OnInit } from '@angular/core';
import { Test } from '../model/test';
import { Observable } from 'rxjs';
import { TestService } from '../service/test-service.service';

@Component({
  selector: 'app-testsincenter',
  templateUrl: 'testsincenter.component.html',
  styleUrls: ['./testsincenter.component.css']
})
export class TestsincenterComponent implements OnInit {
  
  tests:Test[];


  constructor(private testService:TestService) {    

   }


   findTestsByCenterId(idForm){
    let data=idForm.value; 
    let id=data.centerid;
    let observable:Observable<Test[]>=this.testService.findByCenterId(id);
    observable.subscribe(
      (testArg:Test[])=> this.tests=testArg
      ,
      err=>{
        console.log("err msg "+err.error);
      }
    )
   }


  ngOnInit(): void {
   }

}
