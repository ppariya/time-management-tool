package com.example.timetracking.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimesheetDisplay {
    private User user;
    private long clockIn;
    private long clockOut;
    private String date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getClockIn() {
        return clockIn;
    }

    public void setClockIn(long clockIn) {
        this.clockIn = clockIn;
    }

    public long getClockOut() {
        return clockOut;
    }

    public void setClockOut(long clockOut) {
        this.clockOut = clockOut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
