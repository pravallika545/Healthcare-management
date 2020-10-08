import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../authservice';
import { Test } from '../model/test';
import { TestService } from '../service/test-service.service';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent  implements OnInit{

  test: Test;

  errMsg:string;

  constructor(private testService: TestService, private authService:AuthenticationService, private router:Router) {

   }
  
 
  ngOnInit(): void {
    if(!this.authService.isAuthenticated()){
      this.router.navigate(['login']);
   }
  }
    
  addTest(form: any) {
    let data = form.value;
     let name = data.name;
     let centerid=data.centerid;
     this.test = new Test(-1, name,centerid);

    
    let successFun = (testArg: Test) => {
      this.test = testArg;
    };
   
    let errFun = err => {
      console.log("err in addusercomponent " + err.message);
      if(err.status==401){
        this.errMsg="You are not Authorized";
        console.log(this.errMsg);
      }
    }

    let observable: Observable<Test> = this.testService.addTest(this.test);
    observable.subscribe(successFun, errFun);
  }

  

}
