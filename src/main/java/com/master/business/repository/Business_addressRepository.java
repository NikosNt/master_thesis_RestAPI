package com.master.business.repository;


import com.master.business.models.Business_address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Business_addressRepository extends JpaRepository<Business_address, Long> {
}
