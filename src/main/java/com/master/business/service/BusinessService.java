package com.master.business.service;

import com.master.business.models.Business;
import com.master.business.repository.BusinessRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

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

//    public List<Business> listBusinessByTypeAndCity(String type,String city){
//        List<Business> buss = businessRepository.findByTypeAndCity(type,city);
//        return buss;
//    }

}
