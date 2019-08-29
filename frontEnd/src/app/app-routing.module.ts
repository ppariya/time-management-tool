import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimesheetsComponent} from './timesheets/timesheets.component';
import { TimesheetDetailComponent} from './timesheet-detail/timesheet-detail.component';
import { LoginComponent } from './login/login.component';
import {CreateTimesheetComponent} from './create-timesheet/create-timesheet.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'timesheets', component: TimesheetsComponent},
  {path: 'detail/:id', component: TimesheetDetailComponent},
  {path: 'create-timesheet', component: CreateTimesheetComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
