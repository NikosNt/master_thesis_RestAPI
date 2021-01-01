package com.master.products_services.controllers;

import com.master.products_services.models.*;
import com.master.products_services.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Objects.isNull;


@RestController
@CrossOrigin
@RequestMapping("/api/product_services")
public class Products_ServicesController {

    @Autowired
    ProductsService productsService;
    @Autowired
    ServicesService servicesService;

    /*
    Find all products of a business by business_id
    */
    @GetMapping("/products/{business_id}")
    public  ResponseEntity<?> listBusinessProducts(@PathVariable Long business_id){
        List<Products> products = productsService.listProductsByBusiness_id(business_id);
        if( products.isEmpty()){
            return new ResponseEntity<>("No products found !",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    /*
    Add a product to a business
    */
    @PostMapping("/products/add")
    public ResponseEntity<?> createProduct(@RequestBody Products product){
        Products newProduct = productsService.saveProduct(product);
        if(isNull(newProduct)){
            return new ResponseEntity<>("Product add is not Acceptable",HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newProduct,HttpStatus.OK);
    }

    /*
    Delete a product to a business
    */
    @DeleteMapping("/products/delete/{id}")
    public  ResponseEntity<?> productDelete(@PathVariable Long id) {
        try{
            productsService.deleteProduct(id);
            return new ResponseEntity<>("Deleted Successfully !",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<> ("Not Found",HttpStatus.NOT_FOUND);
        }

    }

    /*
    Update a product to a business
    */
    @PutMapping("/products/update/{id}")
    public  ResponseEntity<?> productUpdate(@RequestBody Products product, @PathVariable Long id){
        try{
            Products existProduct =productsService.getProduct(id);
            product.setId(id);
            productsService.saveProduct(product);
            return new ResponseEntity<>("Updated !",HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    //--------------------------------------------------------------------------------------------------

    //view all services of a business by business_id
    @GetMapping("/services/{business_id}")
    public  ResponseEntity<?> listBusinessServices(@PathVariable Long business_id){
        List<Services> services = servicesService.listServicesByBusiness_id(business_id);
        if( services.isEmpty()){
            return new ResponseEntity<>("No services found !",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(services,HttpStatus.OK);
    }

    //add a service to a business
    @PostMapping("/services/add")
    public ResponseEntity<?> createService(@RequestBody Services service){
        Services newService = servicesService.saveService(service);
        if(isNull(newService)){
            return new ResponseEntity<>("Service add is not Acceptable",HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newService,HttpStatus.OK);
    }

    //delete a service to a business
    @DeleteMapping("/services/delete/{id}")
    public ResponseEntity<?> serviceDelete(@PathVariable Long id) {
        try {
            servicesService.deleteService(id);
            return new ResponseEntity<> ("Deleted Successfully  !",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<> ("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    //update a service to a business
    @PutMapping("/services/update/{id}")
    public  ResponseEntity<?> productUpdate(@RequestBody Services service, @PathVariable Long id){
        try{
            Services existService =servicesService.getService(id);
            service.setId(id);
            servicesService.saveService(service);
            return new ResponseEntity<>("Updated !",HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
    }
}
