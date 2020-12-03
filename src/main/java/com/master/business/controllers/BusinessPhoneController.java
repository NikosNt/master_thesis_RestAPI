package com.master.business.controllers;

import com.master.business.service.Business_phonesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services/phone")
public class BusinessPhoneController {

    @Autowired
    Business_phonesService businessPhonesService;

    //delete phone by id
    @DeleteMapping("/delete/{id}")
    public String deletePhone(@PathVariable Long id){
        businessPhonesService.deleteBusinessPhone(id);
        return "Deleted Successfully";
    }

}
