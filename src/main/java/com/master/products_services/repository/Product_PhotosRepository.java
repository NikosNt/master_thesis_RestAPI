package com.master.products_services.repository;

import com.master.products_services.models.Product_Photos;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface Product_PhotosRepository  extends JpaRepository<Product_Photos, String>{
}
