import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './authservice';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'diagnosticcentermgt';

  constructor(private service:AuthenticationService, private router:Router){

  }

  logout(){
      this.service.logout();
      this.router.navigate(['login']);
  }

  isSignedIn(){
    return this.service.isAuthenticated();
  }
}


