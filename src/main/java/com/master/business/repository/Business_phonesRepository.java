package com.master.business.repository;

import com.master.business.models.Business_phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Business_phonesRepository extends JpaRepository<Business_phones, Long> {

}
