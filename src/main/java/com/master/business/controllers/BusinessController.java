package com.master.business.controllers;

import com.master.business.models.*;
import com.master.business.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@CrossOrigin
@RequestMapping("/api/services/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    //finds all business
    @GetMapping("/all")
    public ResponseEntity<?>listBusiness() { return new ResponseEntity<>( businessService.listAllBusiness(),HttpStatus.OK); }

    /*
    Finds business by moderator id
    */
    @GetMapping("/mod/{moderatorId}")
    public ResponseEntity<?> listBusinessByModId(@PathVariable Long moderatorId) {
        Business buss = businessService.listBusinessByModeratorId(moderatorId);
        if(isNull(buss)){
            return new ResponseEntity<>("Business not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buss,HttpStatus.OK);
    }

    /*
    Create new business with all the varibales +phones,address,owner
    */
    @PostMapping("/add")
    public ResponseEntity<?> createBusiness(@Valid @RequestBody Business business){
        Business newBuss = businessService.saveBusiness(business);
        if(isNull(newBuss)){
            return new ResponseEntity<>("Business is not Acceptable", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newBuss,HttpStatus.OK);
    }

    /*
    Delete business by id +phones,address,owner
    */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            businessService.deleteBusiness(id);
            return new ResponseEntity<>( "Deleted Successfully !",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<> ("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    /*
    Update business by id only the basics and create new phones,address,owner
    */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBusiness(@RequestBody Business business, @PathVariable Long id) {
        try {
            Business existBusiness = businessService.getBusiness(id);
            business.setId(id);
            businessService.saveBusiness(business);
           // Business UpdatedBusiness = businessService.listBusinessByModeratorId(business.getModeratorId());
            return new ResponseEntity<>("Updated !",HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    //list all cities of business
    @GetMapping("/by/cities")
    public  ResponseEntity<?> listAllCities(){
        List<String> cities = businessService.listCities();
        return new ResponseEntity<>(cities,HttpStatus.OK);
    }
    //list all types of business
    @GetMapping("/by/types")
    public  ResponseEntity<?> listAllTypes(){
        List<String> types = businessService.listTypes();
        return new ResponseEntity<>(types,HttpStatus.OK);
    }


    @GetMapping("/by/{city}/{type}/{searchBar}/")
    public  ResponseEntity<?> listBusinessByTypeAndCity(@PathVariable String city,@PathVariable String type,@PathVariable String searchBar){
        List<Business> buss = businessService.listBusinessByTypeAndCity(city,type,searchBar);
        return new ResponseEntity<>(buss,HttpStatus.OK);
    }

}
