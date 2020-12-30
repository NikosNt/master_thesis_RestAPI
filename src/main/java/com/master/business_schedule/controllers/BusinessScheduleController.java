package com.master.business_schedule.controllers;


import com.master.business_schedule.models.Business_schedule;
import com.master.business_schedule.services.Business_scheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/schedule")
public class BusinessScheduleController {

    @Autowired
    Business_scheduleService business_scheduleService;

    //find schedule by business id
    @GetMapping("/business/{businessId}")
    public ResponseEntity<?> listScheduleByBusId(@PathVariable Long businessId) {
        List<Business_schedule> schedule = business_scheduleService.listScheduleByBusinessId(businessId);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}
