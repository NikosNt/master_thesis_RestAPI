package com.master.products_services.repository;

import com.master.products_services.models.Products;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {

    List<Products> findBybusinessId(Long businessId);

}
