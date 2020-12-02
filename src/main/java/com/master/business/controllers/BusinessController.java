package com.master.business.controllers;

import com.master.business.models.*;
import com.master.business.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/services")
public class BusinessController {

    @Autowired
    BusinessService businessService;
    @Autowired
    Business_phonesService businessPhonesService;


    //finds all businesses
    @GetMapping("/all/business")
    public ResponseEntity<?>listBusiness() {
        return new ResponseEntity<>( businessService.listAllBusiness(),HttpStatus.OK);
    }

    //finds business by id
    @GetMapping("/mod/{moderatorId}")
    public ResponseEntity<?> listBusinessByModId(@PathVariable Long moderatorId) {
        Business buss = businessService.listBusinessByModeratorId(moderatorId);
        return new ResponseEntity<>(buss,HttpStatus.OK);
    }

    //create new business
    @PostMapping("/add/business")
    public ResponseEntity<?> createBusiness(@Valid @RequestBody Business business){
        Business newBuss = businessService.saveBusiness(business);
        return new ResponseEntity<>(newBuss,HttpStatus.OK);
    }

    //update business by id


    //delete business by id
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        businessService.deleteBusiness(id);
        return "Deleted Successfully";
    }

}
