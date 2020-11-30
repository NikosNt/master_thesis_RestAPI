package com.master.business.controllers;

import com.master.business.models.*;
import com.master.business.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/services")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @GetMapping("/all/business")
    public ResponseEntity<?>listBusiness() {
        return new ResponseEntity<>( businessService.listAllBusiness(),HttpStatus.OK);
    }

    @Autowired
    Business_addressService addressService;

    @GetMapping("/all/address")
    public ResponseEntity<?>listAddress() {
        return new ResponseEntity<>( addressService.listAllAddress(),HttpStatus.OK);
    }

    @Autowired
    Business_ownerService ownerService;

    @GetMapping("/all/owners")
    public ResponseEntity<?>listOwners() {
        return new ResponseEntity<>( ownerService.listAllOwners(),HttpStatus.OK);
    }

    @Autowired
    Business_phonesService phonesService;

    @GetMapping("/all/phones")
    public ResponseEntity<?> listPhones() {
        return new ResponseEntity<>( phonesService.listAllPhones(),HttpStatus.OK);
    }

}
