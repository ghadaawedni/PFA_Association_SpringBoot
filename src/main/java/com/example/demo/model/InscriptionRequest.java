package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Entity
@Table(name = "InscriptionRequest")
public class InscriptionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long request_id;

   @NaturalId
    private String firstName;


    private String lastName;


    private String birthday;


    private String civilStatus;


    private Long phone;


    private String job;


    private String address;


    private String city;


    private String area;


    private int post;


    private String description;


    public InscriptionRequest(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String birthday, @NotBlank String civilStatus, @NotBlank Long phone, @NotBlank String job, @NotBlank String address, @NotBlank String city, @NotBlank String area, @NotBlank int post, @NotBlank String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.civilStatus = civilStatus;
        this.phone = phone;
        this.job = job;
        this.address = address;
        this.city = city;
        this.area = area;
        this.post = post;
        this.description = description;
    }

    public InscriptionRequest() {

    }
}
