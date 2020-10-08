import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddCenterComponent } from './add-center/add-center.component';
import { HomeComponent } from './home/home.component';
import { CenterDetailsComponent } from './center-details/center-details.component';
import { CenterListComponent } from './center-list/center-list.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AddTestComponent } from './add-test/add-test.component';
import { TestDetailsComponent } from './test-details/test-details.component';
import { TestsListComponent } from './tests-list/tests-list.component';
import { TestsincenterComponent } from './testsincenter/testsincenter.component';
import { MakeAppointmentComponent } from './make-appointment/make-appointment.component';
import { GetAppointmentComponent } from './get-appointment/get-appointment.component';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';

const routes: Routes = [
  {
    path:"app-home",
    component:HomeComponent
  },
  {
    path:'',
    redirectTo :'app-home',
    pathMatch:'full'
  },
  {
    path:'center-details',
    component:CenterDetailsComponent
  },
  {
    path:'add-center',
    component:AddCenterComponent
  },
  {
    path:'center-list',
    component:CenterListComponent
  },

  {
    path:'login',
    component:AuthenticateComponent
  }
  ,
  {
    path: 'register',
    component:AddUserComponent
  },
  {
    path:'add-test',
    component:AddTestComponent
  },
  {
    path:"test-details",
    component:TestDetailsComponent
  },
  {
    path:"tests-list",
    component:TestsListComponent
  },
  {
    path:"tests-center",
    component:TestsincenterComponent
  },
  {
    path:"add-appointment",
    component:MakeAppointmentComponent
  },
  {
    path:"get-appointment",
    component:GetAppointmentComponent
  },
  {
    path:"appointment-details",
    component:GetAppointmentComponent
  }
  ,
  {
    path:"approve-appointment",
    component:ApproveAppointmentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }