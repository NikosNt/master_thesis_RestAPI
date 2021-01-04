package com.master.business_schedule.repository;

import com.master.business_schedule.models.Business_schedule;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface Business_scheduleRepository extends  JpaRepository<Business_schedule,Long> {

    List<Business_schedule> findByBusinessId(Long businessId);

    List<Business_schedule> findByBusinessIdAndDay(Long businessId,Integer day);

}
