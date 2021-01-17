package com.master.products_services.services;


import com.master.products_services.repository.Product_PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class Product_PhotosService {

    @Autowired
    private Product_PhotosRepository product_photosRepository;

    /*
    Delete a Photo path
    * */
    public void deleteProductPhoto(Long id){ product_photosRepository.deleteById(id);}

}
