import { Component, OnInit } from '@angular/core';
import {Timesheet} from '../models/timesheet';
import { TimesheetService} from '../services/timesheet.service';

@Component({
  selector: 'app-timesheets',
  templateUrl: './timesheets.component.html',
  styleUrls: ['./timesheets.component.css']
})
export class TimesheetsComponent implements OnInit {
  timesheets: Timesheet[];

  constructor(private timesheetService: TimesheetService) { }
  getTimesheets(): void {
    this.timesheetService.getTimesheets();
  }
  ngOnInit() {
    this.getTimesheets();
  }

}
