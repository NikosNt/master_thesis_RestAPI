package com.master.business.controllers;

import com.master.business.service.BusinessService;
import com.master.business.service.Business_addressService;
import com.master.business.service.Business_ownerService;
import com.master.business.service.Business_phonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/services")
public class TestBusinessController {

    @Autowired
    Business_addressService addressService;
    @Autowired
    Business_ownerService ownerService;
    @Autowired
    Business_phonesService phonesService;
    @Autowired
    BusinessService businessService;


    @GetMapping("/all/business")
    public ResponseEntity<?>listBusiness() { return new ResponseEntity<>( businessService.listAllBusiness(),HttpStatus.OK); }

    @GetMapping("/all/address")
    public ResponseEntity<?>listAddress() { return new ResponseEntity<>( addressService.listAllAddress(),HttpStatus.OK); }

    @GetMapping("/all/owners")
    public ResponseEntity<?>listOwners() {
        return new ResponseEntity<>( ownerService.listAllOwners(),HttpStatus.OK);
    }

    @GetMapping("/all/phones")
    public ResponseEntity<?> listPhones() {
        return new ResponseEntity<>( phonesService.listAllPhones(),HttpStatus.OK);
    }

}

