package com.master.business.controllers;

import com.master.business.service.Business_ownerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services/owner")
public class BusinessOwnerController {

    @Autowired
    Business_ownerService businessOwnerService;

    //delete owner by id
    @DeleteMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id){
        businessOwnerService.deleteBusinessOwner(id);
        return "Deleted Successfully";
    }
}
