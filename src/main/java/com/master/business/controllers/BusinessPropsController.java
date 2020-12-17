package com.master.business.controllers;

import com.master.business.models.Business_type;
import com.master.business.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/services/props")
public class BusinessPropsController {

    @Autowired
    Business_ownerService businessOwnerService;

    //delete owner by id
    @DeleteMapping("/owner/delete/{id}")
    public String deleteOwner(@PathVariable Long id){
        businessOwnerService.deleteBusinessOwner(id);
        return "Deleted Successfully";
    }

    @Autowired
    Business_addressService businessAddressService;

    //delete phone by id
    @DeleteMapping("/address/delete/{id}")
    public String deleteAddress(@PathVariable Long id){
        businessAddressService.deleteBusinessAddress(id);
        return "Deleted Successfully";
    }

    @Autowired
    Business_phonesService businessPhonesService;

    //delete phone by id
    @DeleteMapping("/phone/delete/{id}")
    public String deletePhone(@PathVariable Long id){
        businessPhonesService.deleteBusinessPhone(id);
        return "Deleted Successfully";
    }

    @Autowired
    Business_typeService businessTypeService;

    //delete type by id
    @DeleteMapping("/type/delete/{id}")
    public String deleteType(@PathVariable Long id){
        businessTypeService.deleteBusinessType(id);
        return "Deleted Successfully";
    }
}
