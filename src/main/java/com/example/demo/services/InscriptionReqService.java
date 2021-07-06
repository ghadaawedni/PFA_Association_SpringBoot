package com.example.demo.services;

import com.example.demo.model.InscriptionRequest;
import com.example.demo.repository.InscriptionReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionReqService {

    @Autowired
    private InscriptionReqRepository repository;

    public InscriptionRequest saveInscription(InscriptionRequest inv)
    {
        return   repository.save(inv);
    }

    public List<InscriptionRequest>  saveInscriptions(List<InscriptionRequest> invs)
    {
        return   repository.saveAll(invs);
    }

    public List<InscriptionRequest> getInscriptionRequests()
    {
        return repository.findAll();
    }


    public InscriptionRequest getInscriptionReqById(Long request_id)
    {
        return repository.findById(request_id).orElse(null);
    }

    public InscriptionRequest getInscriptionReqByName(String  firstName)
    {
        return repository.findByFirstName(firstName);
    }

    public String DeleteInscriptionReq(Long request_id)
    {
        repository.deleteById(request_id);
        return "product removed " + request_id;
    }
    public InscriptionRequest updateInscriptionReq(InscriptionRequest inv)
    {
        InscriptionRequest existingInv = repository.findById(inv.getRequest_id()).orElse(null);
        existingInv.setFirstName(inv.getFirstName());
        existingInv.setLastName(inv.getLastName());
        existingInv.setBirthday(inv.getBirthday());
        existingInv.setCivilStatus(inv.getCivilStatus());
        existingInv.setPhone(inv.getPhone());
        existingInv.setJob(inv.getJob());
        existingInv.setAddress(inv.getAddress());
        existingInv.setCity(inv.getCity());
        existingInv.setArea(inv.getArea());
        existingInv.setPost(inv.getPost());
        existingInv.setDescription(inv.getDescription());
        return repository.save(existingInv);
    }

}
