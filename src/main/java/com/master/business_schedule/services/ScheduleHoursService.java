package com.master.business_schedule.services;


import com.master.business_schedule.models.Business_schedule;
import com.master.business_schedule.models.ScheduleHours;
import com.master.business_schedule.repository.Business_scheduleRepository;
import com.master.business_schedule.repository.ScheduleHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class ScheduleHoursService {

    @Autowired
    private ScheduleHoursRepository scheduleHoursRepository;
    @Autowired
    private Business_scheduleRepository business_scheduleRepository;

    //delete a schedule hour
    public void deleteScheduleHour(Long id ) {
    //    System.out.println(id + " - " + dayid);
         scheduleHoursRepository.deleteById(id);
//        Business_schedule b = business_scheduleRepository.findById(dayid).get();
//
//        if (b.getHours().isEmpty()) {
//            System.out.println("Mphka");
//
//        }

    }
}