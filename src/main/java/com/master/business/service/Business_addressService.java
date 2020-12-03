package com.master.business.service;

import com.master.business.models.Business_address;
import com.master.business.repository.Business_addressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Business_addressService {

    @Autowired
    private Business_addressRepository  addressRepository;

    public List<Business_address> listAllAddress (){
        return addressRepository.findAll();
    }

    public void deleteBusinessAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
