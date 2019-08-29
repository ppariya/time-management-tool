import { Injectable } from '@angular/core';
import { Timesheet } from '../models/timesheet';
import { TIMESHEETS } from '../mock-timesheets';
import {Observable, of} from 'rxjs';
import { MessageService } from './message.service';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TimesheetService {
  private url = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) { }

getTimesheets() {
  return this.httpClient.get<Timesheet[]>(`${this.url}/timesheets`)
    .subscribe();
}
addTimesheet(timesheet: Timesheet) {
  this.httpClient.post<Timesheet[]>(`${this.url}/timesheets`, timesheet)
    .subscribe();
}
deleteTimesheet(timesheet: Timesheet) {
  this.httpClient.delete<Timesheet[]>(`${this.url}/timesheets`)
    .subscribe();
}

}
