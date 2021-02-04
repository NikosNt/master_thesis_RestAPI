package com.master.products_services.controllers;

import com.master.products_services.ResponseProduct.ResponseProduct;
import com.master.products_services.message.ResponseFile;
import com.master.products_services.message.ResponseMessage;
import com.master.products_services.models.*;
import com.master.products_services.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;


@RestController
@CrossOrigin
@RequestMapping("/api/product_services")
public class Products_ServicesController {

    @Autowired
    ProductsService productsService;
    @Autowired
    ServicesService servicesService;
    @Autowired
    Product_PhotosService product_photosService;


//--------------------------------- Products ---------------------------------------------------
    /*
    Find all products of a business by business_id
    */
    @GetMapping("/products/{business_id}")
    public  ResponseEntity<?> listBusinessProducts(@PathVariable Long business_id){
        List<Products> products = productsService.listProductsByBusiness_id(business_id);
        if( products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
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

    //------------------------------------- Business Product Images -----------------------------------------------
    @GetMapping("/products-images/{business_id}")
    public  ResponseEntity<?> listBusinessProductsWithImages(@PathVariable Long business_id){
        List<Products> products = productsService.listProductsByBusiness_id(business_id);
        List<ResponseFile> images = product_photosService.getAllFilesByBusinessID(business_id);
        List<ResponseProduct> finalProducts = new ArrayList<>();

        for(Products pr : products){
            List<ResponseFile> imagesProduct = new ArrayList<>();
            for(ResponseFile ref : images){
                if(pr.getId() == ref.getProductId()){
                    imagesProduct.add(ref);
                }

            }
            ResponseProduct fpr = new ResponseProduct(  pr.getId(),
                                                        pr.getName(),
                                                        pr.getNumber(),
                                                        pr.getValue(),
                                                        pr.getInfo(),
                                                        imagesProduct);
            finalProducts.add(fpr);
        }

        if( products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(finalProducts,HttpStatus.OK);
    }
    //-------------------------------------- Images -------------------------------------------

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Product_Photos fileDB = product_photosService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

    @DeleteMapping("/products/image/delete/{id}")
    public ResponseEntity<?> deleteImgById(@PathVariable String id) {
        product_photosService.deleteImg(id);
        return new ResponseEntity<>( "Deleted Successfully !",HttpStatus.OK);
    }
    @PostMapping("/products/image/upload/{businessId}/{productId}")
    public ResponseEntity<ResponseMessage> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Long businessId, @PathVariable Long productId) {
        String message = "";
        try {
            product_photosService.storeImg(file,businessId,productId);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    //View images by product
    @GetMapping("/products/find/images/{id}")
    public ResponseEntity<List<ResponseFile>> getListImagesByProductId(@PathVariable Long id) {
        List<ResponseFile> images = product_photosService.getAllFilesByBusinessID(id);
        return new ResponseEntity<>(images,HttpStatus.OK);

    }


    //-------------------------------------- Services ----------------------------------------------

    //view all services of a business by business_id
    @GetMapping("/services/{business_id}")
    public  ResponseEntity<?> listBusinessServices(@PathVariable Long business_id){
        List<Services> services = servicesService.listServicesByBusiness_id(business_id);
        if( services.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
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
