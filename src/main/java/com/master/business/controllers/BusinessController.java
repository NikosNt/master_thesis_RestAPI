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
@RequestMapping("/api/businesses")
public class BusinessController {

    @Autowired
    BusinessService businessService;

//    @GetMapping("/all")
//    public List<Business> list() {
//
//        return businessService.listAllBusiness();
//    }

    @GetMapping("/all/business")
    public ResponseEntity< List<Business>>listBusiness() {
        return new ResponseEntity<>( businessService.listAllBusiness()
                                     ,HttpStatus.OK);
    }

    @Autowired
    Business_addressService addressService;

    @GetMapping("/all/address")
    public ResponseEntity< List<Business_address>>listAddress() {
        return new ResponseEntity<>( addressService.listAllAddress()
                                    ,HttpStatus.OK);
    }

    @Autowired
    Business_ownerService ownerService;

    @GetMapping("/all/owners")
    public ResponseEntity< List<Business_owner>>listOwners() {
        return new ResponseEntity<>( ownerService.listAllOwners()
                ,HttpStatus.OK);
    }

    @Autowired
    Business_phonesService phonesService;

    @GetMapping("/all/phones")
    public ResponseEntity< List<Business_phones>>listPhones() {
        return new ResponseEntity<>( phonesService.listAllPhones()
                ,HttpStatus.OK);
    }

}
