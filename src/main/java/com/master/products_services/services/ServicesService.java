package com.master.products_services.services;

import com.master.products_services.models.Services;
import com.master.products_services.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;

    /*
    Find all services by business_id
    */
    public List<Services> listServicesByBusiness_id(Long id){
        List<Services> services = servicesRepository.findByBusinessId(id);
        return services;
    }

    /*
    Create a service to a business
    */
    public Services saveService(Services service){
        if(service.getBusiness_id() != null){
            Services savedService = servicesRepository.save(service);
            return savedService;
        }else{
            return null;
        }
    }

    /*
    Delete a service to a business by id
    */
    public void deleteService(Long id ){
        servicesRepository.deleteById(id);
    }

    /*
    Update a service to a business by id
    */
    public Services getService(Long id){
        return servicesRepository.findById(id).get();
    }

}
