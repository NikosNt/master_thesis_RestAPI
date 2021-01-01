package com.master.business.service;

import com.master.business.models.Business_owner;
import com.master.business.repository.Business_ownerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Business_ownerService {

    @Autowired
    private Business_ownerRepository ownerRepository;

    public List<Business_owner> listAllOwners() {
        return ownerRepository.findAll();
    }

    /*
    Delete a owner of a Business
    */
    public void deleteBusinessOwner(Long id) {
        ownerRepository.deleteById(id);
    }

}
