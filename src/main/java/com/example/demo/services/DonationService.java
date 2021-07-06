package com.example.demo.services;

import com.example.demo.model.Donation;
import com.example.demo.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository repository;


    public Donation saveDonation(Donation don)
    {
        return   repository.save(don);
    }

    public List<Donation> saveDonations(List<Donation> invs)
    {
        return   repository.saveAll(invs);
    }

    public List<Donation> getDonations()
    {
        return repository.findAll();
    }


    public Donation getDonationById(Long request_id)
    {
        return repository.findById(request_id).orElse(null);
    }


    public String DeleteDonation(Long request_id)
    {
        repository.deleteById(request_id);
        return "Donation removed " + request_id;
    }

    public Donation updateDonationReq(Donation inv)
    {
        Donation existingInv = repository.findById(inv.getDon_id()).orElse(null);
        existingInv.setFirstName(inv.getFirstName());
        existingInv.setLastName(inv.getLastName());
        existingInv.setPhone(inv.getPhone());
        existingInv.setEmail(inv.getEmail());
        existingInv.setAddress(inv.getAddress());
        existingInv.setDonation(inv.getDonation());
        existingInv.setSugDonation(inv.getSugDonation());
        return repository.save(existingInv);
    }
}
