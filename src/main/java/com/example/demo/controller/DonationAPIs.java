package com.example.demo.controller;


import com.example.demo.model.Donation;
import com.example.demo.model.InscriptionRequest;
import com.example.demo.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )

@RequestMapping("/donation")
public class DonationAPIs {
    @Autowired
    DonationService donationService;

    @PostMapping("/add")
    public Donation addDonation(@RequestBody Donation don) {
        return donationService.saveDonation(don);
    }

    @PostMapping("/addDons")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Donation> addDonations(@RequestBody List<Donation> don) {
        return donationService.saveDonations(don);
    }

    @GetMapping("/getDonations")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Donation> getAllInscription() {
        return donationService.getDonations();
    }


    @GetMapping("/getDonID/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Donation findDonationById(@PathVariable Long id) {
        return donationService.getDonationById(id);
    }


    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Donation updateInv(@RequestBody Donation ins) {
        return donationService.updateDonationReq(ins);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDonation(@PathVariable long id) {
        donationService.DeleteDonation(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Success", "OK");
        return ResponseEntity.accepted().build();
    }
}