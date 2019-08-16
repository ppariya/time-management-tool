package com.example.timetracking.Controller;


import com.example.timetracking.Model.Timesheet;
import com.example.timetracking.Model.TimesheetDisplay;
import com.example.timetracking.Model.User;
import com.example.timetracking.Service.TimesheetService;
import com.example.timetracking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TimesheetController {

    @Autowired
    private UserService userService;

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping(value= {"/timesheet", "/"})
    public String getTimesheetForm(Model model) {
        model.addAttribute("timesheet", new Timesheet());
        return "newTimesheet";
    }

    @PostMapping(value = "/timesheets")
    public String submitTimesheetForm(@Valid Timesheet timesheet, BindingResult bindingResult, Model model) {
        User user = userService.getLoggedInUser();
        if(!bindingResult.hasErrors()){
            timesheet.setUser(user);
            timesheetService.save(timesheet);
            model.addAttribute("successMessage", "Timesheet successfully submitted!");
            model.addAttribute("timesheet", new Timesheet());

        }
        return "newTimesheet";
    }


}
