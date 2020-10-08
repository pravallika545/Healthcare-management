import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { CenterDetailsComponent } from './center-details/center-details.component';
import { CenterListComponent } from './center-list/center-list.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { CenterService } from './service/center.service';
import { TestDetailsComponent } from './test-details/test-details.component';
import { TestsListComponent } from './tests-list/tests-list.component';
import { AddTestComponent } from './add-test/add-test.component';
import { TestsincenterComponent } from './testsincenter/testsincenter.component';
import { GetAppointmentComponent } from './get-appointment/get-appointment.component';
import { MakeAppointmentComponent } from './make-appointment/make-appointment.component';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';
import { TestService } from './service/test-service.service';
import { AppointmentService } from './service/appointmentservice';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { AuthenticationService } from './authservice';
import { AuthInterceptor } from './auth.interceptor';
import { AddUserComponent } from './add-user/add-user.component';
import { UserService } from './service/userservice';


@NgModule({
  declarations: [
    AppComponent,
    AddCenterComponent,
    CenterDetailsComponent,
    CenterListComponent,
    HomeComponent,
    TestDetailsComponent,
    TestsListComponent,
    AddTestComponent,
    TestsincenterComponent,
    GetAppointmentComponent,
    MakeAppointmentComponent,
    ApproveAppointmentComponent,
    AuthenticateComponent,
    AddUserComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
   
    
  ],
  providers: [
    CenterService,
    HttpClient,
    TestService,
    AppointmentService,
    AuthenticationService,
    UserService,

    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
    
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
