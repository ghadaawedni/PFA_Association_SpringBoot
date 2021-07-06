package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_id;

    @NaturalId
    private String firstName;

    private String lastName;

    private Long phone;

    private String email;

    private String civilStatus;

    private String Job;

    private String typeService;

    private String otherService;

    private String emptyTime;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private StateService stateService;

    public Services() {
    }

    public Services(String firstName, String lastName, Long phone, String email, String civilStatus, String Job, String typeService, String otherService, String emptyTime, StateService stateService) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.civilStatus = civilStatus;
        this.Job = Job;
        this.typeService = typeService;
        this.otherService = otherService;
        this.emptyTime = emptyTime;
        this.stateService = stateService;
    }
}
