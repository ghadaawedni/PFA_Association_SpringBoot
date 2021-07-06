package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "membre")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    private String firstName;

    private String lastName;

    private String post;

    private String  url;

    public Member() {
    }

    public Member(String firstName, String lastName, String post, String url) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.post = post;
        this.url = url;
    }
}
