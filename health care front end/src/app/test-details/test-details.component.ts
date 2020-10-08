import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import {Test} from '../model/test'
import { TestService } from '../service/test-service.service';

@Component({
  selector: 'app-test-details',
  templateUrl: './test-details.component.html',
  styleUrls: ['./test-details.component.css']
})
export class TestDetailsComponent implements OnInit {

  constructor(private route:ActivatedRoute, private testService:TestService) {

    }
 
    test:Test;
 
 
    findTestById(idform){
      let data=idform.value;
      let testId=data.testid;
     let observable:Observable<Test>=this.testService.getTest(testId);
     observable.subscribe(
       testArg=>{
         this.test=testArg;
       },
 
       err=>{
         console.log("isnide test details, err is "+err.message);
       }
 
     );
    }
 
   findTest(form:any){
     let data=form.value;
     let id=data.testid;
    this.findTestById(id);
   }
 
   ngOnInit(): void {
   }
   
   }