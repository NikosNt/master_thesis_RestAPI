package com.master.business.service;

import com.master.business.models.Business_phones;
import com.master.business.repository.Business_phonesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Business_phonesService {

    @Autowired
    private Business_phonesRepository phoneRepository;

    public List<Business_phones> listAllPhones() { return phoneRepository.findAll(); }

    public void deleteBusinessPhone(Long id) {
        phoneRepository.deleteById(id);
    }
}
