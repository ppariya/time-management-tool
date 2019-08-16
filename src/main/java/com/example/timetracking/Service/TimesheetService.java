package com.example.timetracking.Service;

import com.example.timetracking.Model.Timesheet;
import com.example.timetracking.Model.TimesheetDisplay;
import com.example.timetracking.Model.User;
import com.example.timetracking.Repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ocpsoft.prettytime.PrettyTime;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TimesheetService {
    @Autowired
    private TimesheetRepository timesheetRepository;





    public List<TimesheetDisplay> findAllByUser(User user) {
        List<Timesheet> timesheets = timesheetRepository.findAllByUserOrderByCreatedAtDesc(user);
        return formatTimesheets(timesheets);
    }





    public void save(Timesheet timesheet) {

        timesheetRepository.save(timesheet);
    }



    private List<TimesheetDisplay> formatTimesheets(List<Timesheet> timesheets) {
        List<TimesheetDisplay> displayTimesheets = formatTimestamps(timesheets);
        return displayTimesheets;
    }

    private List<TimesheetDisplay> formatTimestamps(List<Timesheet> timesheets){
        List<TimesheetDisplay> response = new ArrayList<>();
        PrettyTime prettyTime = new PrettyTime();
        SimpleDateFormat simpleDate = new SimpleDateFormat("M/d/yy");
        Date now = new Date();
        for(Timesheet timesheet : timesheets) {
            TimesheetDisplay timesheetDisplay = new TimesheetDisplay();
            timesheetDisplay.setUser(timesheet.getUser());
            long diffInMillies = Math.abs(now.getTime() - timesheet.getCreatedAt().getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (diff > 3) {
                timesheetDisplay.setDate(simpleDate.format(timesheet.getCreatedAt()));
            } else {
                timesheetDisplay.setDate(prettyTime.format(timesheet.getCreatedAt()));
            }
            response.add(timesheetDisplay);
        }
        return response;
    }






}
