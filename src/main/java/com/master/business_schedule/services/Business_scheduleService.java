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

    /*
    Find schedule of a business by business_id
    */
    public List<Business_schedule> listScheduleByBusinessId(Long businessId){
        List<Business_schedule> businessSchedule = business_scheduleRepository.findByBusinessId(businessId);
        return businessSchedule;
    }

    /*
    Find schedule of a business by business_id and Day
    */
    public List<Business_schedule> listScheduleByBusinessIdAndDay(Long businessId,Integer day){
        List<Business_schedule> businessScheduleDay = business_scheduleRepository.findByBusinessIdAndDay(businessId,day);
        return businessScheduleDay;
    }

    /*
    Create a new schedule entry by day
    */
    public Business_schedule saveScheduleDay(Business_schedule schedule){
        if(schedule.getBusinessId() != null && schedule.getDay() != null && schedule.getState() != null ){
            Business_schedule saveSchedule = business_scheduleRepository.save(schedule);
            return  saveSchedule;
        }else{
            return null;
        }
    }

    /*
    Delete a schedule entry by day
    */
    public void deleteScheduleDay (Long id) {
        business_scheduleRepository.deleteById(id);
    }

    /*
    Update basic info of a schedule entry by day
    */
    public Business_schedule getScheduleDay (Long id){
        return business_scheduleRepository.findById(id).get();
    }
}

