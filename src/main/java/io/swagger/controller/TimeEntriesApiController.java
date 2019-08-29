package io.swagger.controller;

import io.swagger.api.TimeEntriesApi;
import io.swagger.model.TimeEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.UserModel;
import io.swagger.repository.CredentialRepository;
import io.swagger.repository.TimeEntriesRepository;
import io.swagger.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-16T02:49:07.097Z")

@Controller
public class TimeEntriesApiController implements TimeEntriesApi {

    private static final Logger log = LoggerFactory.getLogger(TimeEntriesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TimeEntriesRepository timeEntriesRepository;

    @Autowired
    CredentialRepository credentialRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public TimeEntriesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> timeEntriesPost(@ApiParam(value = "Username, start time, and end time." ,required=true )  @Valid @RequestBody TimeEntry body) {
        timeEntriesRepository.save(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<TimeEntry>> timeEntriesUserIDGet(Long userId) {
//        List<TimeEntry> timeEntries = timeEntriesRepository.findAllByUserModel_Id(userId);
        return new ResponseEntity<List<TimeEntry>>(HttpStatus.OK);
    }

}
