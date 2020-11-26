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
    public List<Business> listAllBusiness() {
        return businessRepository.findAll();
    }

}
