package com.master.business.repository;

import com.master.business.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{

    Business findBymoderatorId(Long moderatorId);

//    @Query(value = "select distinct b from Business b inner join Business_address a,Business_type t where a.city= :city_name and t.type = :type_name ")
//    List<Business> findTypeAndCity(@Param("city_name") String cityName,@Param("type_name") String typeName);

//    List<Business> findBy_City_Type( String cityName, String typeName);

    @Query("select distinct a.city from  Business_address a ")
     List<String> findAllCities();

    @Query("select distinct t.type from Business_type t  ")
    List<String> findAllTypes();

}
