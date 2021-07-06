package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "ComingEvent")
public class ComingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;

    private String title;


    @Temporal(TemporalType.DATE)
    private Date date;

    private String description;


    private String url;

    public ComingEvent() {
    }

    public ComingEvent(String title, Date date, String description, String url) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.url = url;
    }
}
