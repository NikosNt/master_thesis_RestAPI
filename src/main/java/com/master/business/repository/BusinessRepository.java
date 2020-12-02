package com.master.business.repository;

import com.master.business.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{

    Business findBymoderatorId(Long moderatorId);
}
