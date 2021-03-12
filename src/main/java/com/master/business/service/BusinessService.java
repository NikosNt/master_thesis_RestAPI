package com.master.business.service;

import com.master.business.Business_Response;
import com.master.business.models.Business;
import com.master.business.models.Business_address;
import com.master.business.models.Business_type;
import com.master.business.repository.BusinessRepository;

import com.master.business_schedule.models.Business_schedule;
import com.master.business_schedule.models.ScheduleHours;
import com.master.business_schedule.repository.Business_scheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    Business_scheduleRepository business_scheduleRepository;

    /*
    Find all business
    */
    public List<Business> listAllBusiness() {
        return businessRepository.findAll();
    }

    /*
    Find business by business id
    */
    public Business listBusinessByBusinessId(Long businessId) {
        Business buss = businessRepository.findById(businessId).get();
        return buss;
    }
    /*
    Find business by moderator id
    */
    public Business listBusinessByModeratorId(Long moderatorId) {
        Business buss = businessRepository.findBymoderatorId(moderatorId);
        return buss;
    }

    /*
    Create a new business
    */
    public Business saveBusiness(Business business) {
        if(business.getModeratorId()!= null && business.getBusiness_name() != null){
            Business savedBusiness = businessRepository.save(business);

            Set<ScheduleHours> EmptySet = Collections.<ScheduleHours>emptySet();

            for(Integer i=0;i<7;i++) {
                Business_schedule schedule = new Business_schedule(savedBusiness.getId(),i,-1,EmptySet );
                business_scheduleRepository.save(schedule);
            }
            return savedBusiness;
        }else{
            return null ;
        }
    }

    /*
    Update business by id
    */
    public Business getBusiness(Long id){
        return businessRepository.findById(id).get();
    }

    public Business updateSaveBusiness(Business business) {
        if(business.getModeratorId()!= null && business.getBusiness_name() != null){
            Business savedBusiness = businessRepository.save(business);
            return savedBusiness;
        }else{
            return null ;
        }
    }

    /*
    Delete business by id
    */
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }

    /*
    List all cities of business
    */
    public List<String> listCities(){
        List<String> cities = businessRepository.findAllCities();
        return cities;
    }

    /*
    List all types of business
    */
    public List<String> listTypes(){
        List<String> types = businessRepository.findAllTypes();
        return types;
    }


    /*
    Briskei Business me bash  city, type, searchText
    */

    public List<Business_Response> listBusinessByTypeAndCity(String city,String type,String searchBar){
        System.out.println("Sto service -> " + city +" - "+ type + " - "+ searchBar  );
        List<Business> all_business = businessRepository.findAll();
        List<Business> business = new ArrayList<>();

        if( ( city.equals("empty")  || city.equals("Όλες") ) && ( type.equals("empty") || type.equals("Όλες") )  &&  searchBar.equals("empty") ){//an den exw epilogh
//            for(Business bus : all_business){
//                business.add(bus);
//            }


            business = all_business;
        }

        if( ( city.equals("empty")  || city.equals("Όλες") ) && !type.equals("empty") &&  searchBar.equals("empty") ){//an exw epileksh mono type
            for(Business bus : all_business){
                Set<Business_type>  bus_type  = bus.getB_type();
                for(Business_type bus_t : bus_type){
                    if(bus_t.getType().equals(type)){
                        business.add(bus);
                    }
                }
            }
        }

        if( !city.equals("empty")  && ( type.equals("empty") || type.equals("Όλες") )  &&  searchBar.equals("empty")) {//an exw epileksh mono city
            for(Business bus : all_business){
                Set<Business_address>  bus_address  = bus.getAddress();
                Integer flag = 0;
                for(Business_address bus_add : bus_address){
                    if(bus_add.getCity().equals(city) && flag == 0){
                        flag = 1;
                        business.add(bus);
                    }
                }
            }
        }

        if( ( city.equals("empty")  || city.equals("Όλες") ) && !searchBar.equals("empty")){//an exei epileksi mono search bar
            for(Business bus : all_business){
                Set<Business_type>  bus_type  = bus.getB_type();
                for(Business_type bus_t : bus_type){
                    if(bus_t.getType().equals(searchBar)){
                        business.add(bus);
                    }
                }
            }
        }

        if( (!city.equals("empty") && !city.equals("Όλες")) && (!type.equals("empty") && !type.equals("Όλες")) && searchBar.equals("empty") ){//an exei epileksi polh kai type
            List<Business> temp_business = new ArrayList<>();
            for(Business bus : all_business){
                Set<Business_address>  bus_address  = bus.getAddress();
                Integer flag = 0;
                for(Business_address bus_add : bus_address){
                    if(bus_add.getCity().equals(city) && flag == 0){
                        flag = 1;
                        temp_business.add(bus);
                    }
                }
            }
            for(Business bus : temp_business){
                Set<Business_type>  bus_type  = bus.getB_type();
                for(Business_type bus_t : bus_type){
                    if(bus_t.getType().equals(type)){
                        business.add(bus);
                    }
                }
            }
        }

        if( (!city.equals("empty") && !city.equals("Όλες")) && !searchBar.equals("empty")){//an exei epileksi polh kai search
            List<Business> temp_business = new ArrayList<>();
            for(Business bus : all_business){
                Set<Business_address>  bus_address  = bus.getAddress();
              //  Integer flag = 0;
                for(Business_address bus_add : bus_address){
                    if(bus_add.getCity().equals(city)  ){
                      //  flag = 1;
                        temp_business.add(bus);
                    }
                }
            }
            for(Business bus : temp_business){
                Set<Business_type>  bus_type  = bus.getB_type();
                for(Business_type bus_t : bus_type){
                    if(bus_t.getType().equals(searchBar)){
                        business.add(bus);
                    }
                }
            }
        }

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Integer k =  cal.get(Calendar.DAY_OF_WEEK);

        List<Business_schedule> all_business_schedule = business_scheduleRepository.findAll();
        List<Business_Response> result = new ArrayList<>();

        for(Business buss:business){
            for(Business_schedule schedule: all_business_schedule ){
                if(buss.getId() == schedule.getBusinessId()  && (schedule.getDay()+1) ==k   ){
                    Business_Response response = new Business_Response( buss.getId(),
                                                                        buss.getModeratorId(),
                                                                        buss.getBusiness_name(),
                                                                        buss.getRating(),
                                                                        buss.getInfo(),
                                                                        buss.getRef(),
                                                                        buss.getOwner(),
                                                                        buss.getB_type(),
                                                                        buss.getAddress(),
                                                                        buss.getPhones(),
                                                                        schedule.getDay(),
                                                                        schedule.getState(),
                                                                        schedule.getHours());
                    result.add(response);
                }

            }
        }

        return result;
    }



}
