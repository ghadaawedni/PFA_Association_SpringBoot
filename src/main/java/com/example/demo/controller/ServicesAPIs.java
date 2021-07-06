package com.example.demo.controller;

import com.example.demo.model.Services;
import com.example.demo.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )

@RequestMapping("/services")
public class ServicesAPIs {
    @Autowired
    ServicesService service;
    
    @PostMapping("/add")
    public Services addServicesReq(@RequestBody Services ser)
    {
        return service.saveService(ser);
    }

    @PostMapping("/addServices")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Services> addServices(@RequestBody List<Services> services)
    {
        return service.saveServices(services);
    }

    @GetMapping("/getServices")
    public List<Services> getAllServices()
    {
        return service.getServices();
    }


    @GetMapping("/getServiceID/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Services findServiceById(@PathVariable Long id)
    {
        return service.getServiceById(id);
    }


    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Services updateService(@RequestBody Services ser)
    {
        return service.updateServiceReq(ser);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteService(@PathVariable long id)
    {
        service.DeleteServiceReq(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Success", "OK");
        return ResponseEntity.accepted().build();
    }
}
