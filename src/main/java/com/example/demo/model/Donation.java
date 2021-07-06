package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long don_id;
    private String firstName;
    private String LastName;
    private Long phone;
    private String email;
    private String address;
    private float donation;
    private float SugDonation;

    public Donation() {
    }

    public Donation(String firstName, String lastName, Long phone, String email, String address, float donation, float sugDonation) {
        this.firstName = firstName;
        LastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.donation = donation;
        SugDonation = sugDonation;
    }
}
