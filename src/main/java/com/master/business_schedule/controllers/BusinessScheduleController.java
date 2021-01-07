package com.master.business_schedule.controllers;


import com.master.business_schedule.models.Business_schedule;
import com.master.business_schedule.services.Business_scheduleService;
import com.master.business_schedule.services.ScheduleHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

@RestController
@CrossOrigin
@RequestMapping("/api/schedule")
public class BusinessScheduleController {

    @Autowired
    Business_scheduleService business_scheduleService;
    @Autowired
    ScheduleHoursService scheduleHoursService;

    //find schedule by business id All the Days
    @GetMapping("/business/{businessId}")
    public ResponseEntity<?> listScheduleByBusId(@PathVariable Long businessId) {
        List<Business_schedule> schedule = business_scheduleService.listScheduleByBusinessId(businessId);
        if( schedule.isEmpty()){
            return new ResponseEntity<>("Schedule for Business not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    //MALON DEN 8A TO XREIASTO
    //find schedule by business id and day for One Day
    @GetMapping("/business/{businessId}/{day}")
    public ResponseEntity<?> listScheduleByBusIdAndDay(@PathVariable Long businessId,@PathVariable Integer day) {
        List<Business_schedule> scheduleDay = business_scheduleService.listScheduleByBusinessIdAndDay(businessId,day);
        if( scheduleDay.isEmpty()){
            return new ResponseEntity<>("Schedule Day for Business not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(scheduleDay, HttpStatus.OK);
    }

    //MALON DEN 8A TO XREIASTO
    /*
    Save a schedule Day for a business( me wres an 8elw )
    */
    @PostMapping("/add/day")
    public ResponseEntity<?> createNewScheduleDay(@Valid @RequestBody Business_schedule schedule){
        Business_schedule newDaySchedule = business_scheduleService.saveScheduleDay(schedule);
        if( isNull(newDaySchedule)){
            return new ResponseEntity<>("Schedule Day for Business not Acceptable", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newDaySchedule,HttpStatus.OK);
    }

    //MALON DEN 8A TO XREIASTO
    /*
    Delete a schedule Day for a business ( me tis wres)
    */
    @DeleteMapping("/delete/day/{id}")
    public ResponseEntity<?> deleteScheduleDay(@PathVariable Long id) {
        try{
        business_scheduleService.deleteScheduleDay(id);
        return new ResponseEntity<>( "Deleted Successfully !",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<> ("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    /*
    Update a schedule Day for a business (ta basic kai create nea wra)
    */
    @PutMapping("/update/day/{id}")
    public ResponseEntity<?> updateScheduleDay(@RequestBody Business_schedule scheduleDay, @PathVariable Long id){
        try{
            Business_schedule existBusinessSchedule = business_scheduleService.getScheduleDay(id);
            scheduleDay.setId(id);
            business_scheduleService.saveScheduleDay(scheduleDay);
            return new ResponseEntity<>("Updated !",HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Update for Schedule Day of Business not Found",HttpStatus.NOT_FOUND);
        }
    }


    /*
    Delete a schedule hour for a business
    */
    @DeleteMapping("/delete/hour/{id}")
    public ResponseEntity<?> deleteHour(@PathVariable Long id){
        try{
            scheduleHoursService.deleteScheduleHour(id);
            return new ResponseEntity<> ("Deleted Successfully",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<> ("Not Found",HttpStatus.NOT_FOUND);
        }
    }


}
