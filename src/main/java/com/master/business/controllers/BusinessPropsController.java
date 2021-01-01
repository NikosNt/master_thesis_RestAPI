package com.master.business.controllers;

import com.master.business.models.Business_type;
import com.master.business.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/services/props")
public class BusinessPropsController {

    @Autowired
    Business_ownerService businessOwnerService;
    @Autowired
    Business_addressService businessAddressService;
    @Autowired
    Business_phonesService businessPhonesService;
    @Autowired
    Business_typeService businessTypeService;


    /*
    Delete owner by id
    */
    @DeleteMapping("/owner/delete/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long id){
        try{
            businessOwnerService.deleteBusinessOwner(id);
            return  new ResponseEntity<> ("Deleted Successfully !",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> ("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    /*
    Delete address by id
    */
    @DeleteMapping("/address/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id){
        try{
            businessAddressService.deleteBusinessAddress(id);
            return  new ResponseEntity<> ("Deleted Successfully !",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> ("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    /*
    Delete phone by id
    */
    @DeleteMapping("/phone/delete/{id}")
    public ResponseEntity<?> deletePhone(@PathVariable Long id){
        try{
            businessPhonesService.deleteBusinessPhone(id);
            return  new ResponseEntity<> ("Deleted Successfully !",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> ("Not Found", HttpStatus.NOT_FOUND);
        }
    }


    /*
    Delete type by id
    */
    @DeleteMapping("/type/delete/{id}")
    public ResponseEntity<?> deleteType(@PathVariable Long id){
        try{
            businessTypeService.deleteBusinessType(id);
            return  new ResponseEntity<> ("Deleted Successfully !",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> ("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
