package com.master.business.repository;

import com.master.business.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{

    Business findBymoderatorId(Long moderatorId);

    @Query("select distinct a.city from  Business_address a ")
    List<String> findAllCities();

    @Query("select distinct t.type from Business_type t  ")
    List<String> findAllTypes();

}
