package com.master.products_services.services;

import com.master.products_services.models.Products;
import com.master.products_services.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    /*
    Find all products by business_id
     */
    public List<Products> listProductsByBusiness_id(Long id){
        List<Products> prod = productsRepository.findBybusinessId(id);
        return prod;
    }

    /*
    Create a product to a business
    */
    public Products saveProduct(Products product){
        if(product.getBusiness_id() != null){
            Products savedProduct = productsRepository.save(product);
            return savedProduct;
        }else{
            return null;
        }

    }

    /*
    Delete a product to a business by id
    */
    public void deleteProduct(Long id ){
        productsRepository.deleteById(id);
    }

    /*
    Update a product to a business by id
    */
    public Products getProduct(Long id){
        return productsRepository.findById(id).get();
    }

}
