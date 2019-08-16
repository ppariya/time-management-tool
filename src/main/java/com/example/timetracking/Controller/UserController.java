package com.example.timetracking.Controller;

import com.example.timetracking.Model.Timesheet;
import com.example.timetracking.Model.TimesheetDisplay;
import com.example.timetracking.Model.User;
import com.example.timetracking.Service.TimesheetService;
import com.example.timetracking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping(value = "/users/{username}")
    public String getUser(@PathVariable(value = "username") String username, Model model) {
        User user = userService.findByUsername(username);
        List<TimesheetDisplay> timesheets = timesheetService.findAllByUser(user);
        User loggedInUser = userService.getLoggedInUser();
        return "userTimesheet";
    }
}
