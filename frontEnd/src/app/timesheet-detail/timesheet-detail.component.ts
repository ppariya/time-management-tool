import { Component, OnInit, Input } from '@angular/core';
import { Timesheet } from '../models/timesheet';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
import { TimesheetService } from '../services/timesheet.service';

@Component({
  selector: 'app-timesheet-detail',
  templateUrl: './timesheet-detail.component.html',
  styleUrls: ['./timesheet-detail.component.css']
})
export class TimesheetDetailComponent implements OnInit {
  @Input() timesheet: Timesheet;
  constructor(
    private route: ActivatedRoute,
    private timesheetService: TimesheetService,
    private location: Location
  ) { }

  ngOnInit(): void {
  }
  goBack(): void {
    this.location.back();
  }

}
