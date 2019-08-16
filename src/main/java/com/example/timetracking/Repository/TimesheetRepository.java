package com.example.timetracking.Repository;


import com.example.timetracking.Model.Timesheet;
import com.example.timetracking.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {

    List<Timesheet> findAllByUserOrderByCreatedAtDesc(User user);

}