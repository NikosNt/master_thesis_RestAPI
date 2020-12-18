package com.master.business.service;

import com.master.business.models.Business;
import com.master.business.models.Business_address;
import com.master.business.models.Business_type;
import com.master.business.repository.BusinessRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    //find all business
    public List<Business> listAllBusiness() {
        return businessRepository.findAll();
    }

    //find business by moderator id
    public Business listBusinessByModeratorId(Long moderatorId) {
        Business buss = businessRepository.findBymoderatorId(moderatorId);
        return buss;
    }

    //create a new business
    public Business saveBusiness(Business business) {
        Business savedBusiness = businessRepository.save(business);
        return savedBusiness;
    }

    //update business by id
    public Business getBusiness(Long id){ return businessRepository.findById(id).get(); }

    //delete business by id
    public void deleteBusiness(Long id) { businessRepository.deleteById(id); }

    //list all cities of business
    public List<String> listCities(){
        List<String> cities = businessRepository.findAllCities();
        return cities;
    }

    //list all types of business
    public List<String> listTypes(){
        List<String> types = businessRepository.findAllTypes();
        return types;
    }


    //na sbisw ola ta console
    public List<Business> listBusinessByTypeAndCity(String city,String type,String searchBar){
        System.out.println("Sto service -> " + city +" - "+ type + " - "+ searchBar  );
        List<Business> all_business = businessRepository.findAll();
        List<Business> business = new ArrayList<>();

        if( ( city.equals("empty")  || city.equals("All cities") ) && ( type.equals("empty") || type.equals("All types") )  &&  searchBar.equals("empty") ){//an den exw epilogh
            System.out.println("ola h tipota");
            business = all_business;
        }

        if( ( city.equals("empty")  || city.equals("All cities") ) && !type.equals("empty") &&  searchBar.equals("empty") ){//an exw epileksh mono type
            System.out.println("mono type");
            for(Business bus : all_business){
                Set<Business_type>  bus_type  = bus.getB_type();
                for(Business_type bus_t : bus_type){
                    if(bus_t.getType().equals(type)){
                        business.add(bus);
                    }
                }
            }
        }

        if( !city.equals("empty")  && ( type.equals("empty") || type.equals("All types") )  &&  searchBar.equals("empty")) {//an exw epileksh mono city
            System.out.println("mono city");
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

        if( ( city.equals("empty")  || city.equals("All cities") ) && !searchBar.equals("empty")){//an exei epileksi mono search bar
            System.out.println("mono serach me to city na einai -> emty/all cities ");
            for(Business bus : all_business){
                Set<Business_type>  bus_type  = bus.getB_type();
                for(Business_type bus_t : bus_type){
                    if(bus_t.getType().equals(searchBar)){
                        business.add(bus);
                    }
                }
            }
        }

        if( (!city.equals("empty") && !city.equals("All cities")) && (!type.equals("empty") && !type.equals("All types")) && searchBar.equals("empty") ){//an exei epileksi polh kai type
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

        if( (!city.equals("empty") && !city.equals("All cities")) && !searchBar.equals("empty")){//an exei epileksi polh kai search
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
                    if(bus_t.getType().equals(searchBar)){
                        business.add(bus);
                    }
                }
            }
        }

        return business;
    }



}
