package com.master.business.repository;

import com.master.business.models.Business_owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Business_ownerRepository extends JpaRepository<Business_owner,Long>{

}
