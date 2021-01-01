package com.master.business.service;

import com.master.business.models.Business_type;
import com.master.business.repository.Business_typeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Business_typeService {

    @Autowired
    private Business_typeRepository typeRepository;

    public List<Business_type> listAllPhones() { return typeRepository.findAll(); }

    /*
    Delete a type of a Business
    */
    public void deleteBusinessType(Long id) {
        typeRepository.deleteById(id);
    }
}
