import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserService } from '../service/userservice';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user:User;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  addUser(form:any){
    let data=form.value;
    let username=data.username;
    let password=data.password;
    this.user=new User();
    this.user.username=username;
    this.user.password=password;
    let observable:Observable<User>= this.userService.addUser(this.user);
    observable.subscribe(
    (user)=>this.user=user,
    err=>{
      console.log("err is "+err.error);
    }

    );
  }
}
