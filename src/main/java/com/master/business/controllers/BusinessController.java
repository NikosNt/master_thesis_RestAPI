package com.master.business.controllers;

import com.master.business.models.Business;
import com.master.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    @Autowired
    BusinessService businessService;

//    @GetMapping("/all")
//    public List<Business> list() {
//
//        return businessService.listAllBusiness();
//    }

    @GetMapping("/all")
    public ResponseEntity< List<Business>>list() {
        return new ResponseEntity<>( businessService.listAllBusiness()
                                     ,HttpStatus.OK);
    }
}
