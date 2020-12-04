package com.master.business.repository;


import com.master.business.models.Business_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Business_typeRepository extends JpaRepository<Business_type, Long> {
}
