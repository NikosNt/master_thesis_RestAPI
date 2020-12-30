package com.master.business_schedule.services;


import com.master.business_schedule.repository.ScheduleHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class ScheduleHoursService {

    @Autowired
    private ScheduleHoursRepository scheduleHoursRepository;
}
