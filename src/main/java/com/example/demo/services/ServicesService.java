package com.example.demo.services;

import com.example.demo.model.Services;
import com.example.demo.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {

    @Autowired
    ServicesRepository repository;

    public Services saveService(Services service)
    {
        return   repository.save(service);
    }

    public List<Services> saveServices(List<Services> services)
    {
        return   repository.saveAll(services);
    }

    public List<Services> getServices()
    {
        return repository.findAll();
    }


    public Services getServiceById(Long service_id)
    {
        return repository.findById(service_id).orElse(null);
    }


    public String DeleteServiceReq(Long service_id)
    {
        repository.deleteById(service_id);
        return "service removed " + service_id;
    }
    public Services updateServiceReq(Services ser)
    {
        Services services = repository.findById(ser.getService_id()).orElse(null);
        services.setFirstName(ser.getFirstName());
        services.setLastName(ser.getLastName());
        services.setPhone(ser.getPhone());
        services.setEmail(ser.getEmail());
        services.setCivilStatus(ser.getCivilStatus());
        services.setJob(services.getJob());
        services.setTypeService(ser.getTypeService());
        services.setOtherService(ser.getOtherService());
        services.setEmptyTime(ser.getEmptyTime());
        services.setStateService(ser.getStateService());
        return repository.save(services);
    }
}
