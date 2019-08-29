import { Component, OnInit } from '@angular/core';
import {TimesheetService} from '../services/timesheet.service';
import {Timesheet} from '../models/timesheet';

@Component({
  selector: 'app-create-timesheet',
  templateUrl: './create-timesheet.component.html',
  styleUrls: ['./create-timesheet.component.css']
})
export class CreateTimesheetComponent implements OnInit {

  private timesheet = new Timesheet();

  constructor(private timesheetService: TimesheetService) {
  }

  ngOnInit() {
  }
  submitTimesheet(){
    this.timesheetService.addTimesheet(this.timesheet);
  }

}
