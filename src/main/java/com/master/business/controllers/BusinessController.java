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

}
