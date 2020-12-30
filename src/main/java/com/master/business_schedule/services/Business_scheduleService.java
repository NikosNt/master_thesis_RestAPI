package com.master.business_schedule.services;

import com.master.business_schedule.models.Business_schedule;
import com.master.business_schedule.repository.Business_scheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Business_scheduleService {

    @Autowired
    private Business_scheduleRepository business_scheduleRepository;

    //find schedule by business id
    public List<Business_schedule> listScheduleByBusinessId(Long businessId){
        List<Business_schedule> businessSchedule = business_scheduleRepository.findByBusinessId(businessId);
        return businessSchedule;
    }

}
