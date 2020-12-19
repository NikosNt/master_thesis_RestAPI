package com.master.products_services.repository;

import com.master.products_services.models.Services;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services,Long> {

    List<Services> findByBusinessId(Long businessId);

}
