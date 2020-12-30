package com.master.business_schedule.repository;

import com.master.business_schedule.models.ScheduleHours;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ScheduleHoursRepository extends  JpaRepository<ScheduleHours,Long>{

}
