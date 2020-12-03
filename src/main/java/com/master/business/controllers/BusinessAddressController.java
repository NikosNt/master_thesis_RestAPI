package com.master.business.controllers;

import com.master.business.service.Business_addressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services/address")
public class BusinessAddressController {

    @Autowired
    Business_addressService businessAddressService;

    //delete phone by id
    @DeleteMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id){
        businessAddressService.deleteBusinessAddress(id);
        return "Deleted Successfully";
    }
}
