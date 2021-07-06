package com.example.demo.controller;

import com.example.demo.model.InscriptionRequest;
import com.example.demo.services.InscriptionReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )

@RequestMapping("/inscription")
public class InscriptionReqAPIs {
    @Autowired
    private InscriptionReqService service;


    @PostMapping("/addInv")
    public InscriptionRequest addInscriptionReq(@RequestBody InscriptionRequest inv)
    {
      return service.saveInscription(inv);
    }

    @PostMapping("/addInvs")
    @PreAuthorize("hasRole('ADMIN')")
    public List<InscriptionRequest> addInscriptionReqs(@RequestBody List<InscriptionRequest> inv)
    {
        return service.saveInscriptions(inv);
    }

    @GetMapping("/getInvs")
    @PreAuthorize("hasRole('ADMIN')")
    public List<InscriptionRequest> getAllInscription()
    {
        return service.getInscriptionRequests();
    }


    @GetMapping("/getInvID/{request_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public InscriptionRequest findInvById(@PathVariable Long request_id)
    {
        return service.getInscriptionReqById(request_id);
    }

    @GetMapping("/getInvName/{firstName}")
    @PreAuthorize("hasRole('ADMIN')")
    public InscriptionRequest findInvByName(@PathVariable String firstName)
    {
        return service.getInscriptionReqByName(firstName);
    }


    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public InscriptionRequest updateInv(@RequestBody InscriptionRequest ins)
    {
        return service.updateInscriptionReq(ins);
    }

    @DeleteMapping("/delete/{request_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteInscription(@PathVariable Long request_id)
    {
        return service.DeleteInscriptionReq(request_id);
    }

}
