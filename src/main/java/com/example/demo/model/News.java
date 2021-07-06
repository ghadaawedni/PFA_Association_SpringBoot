package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "News")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long news_id ;

    private String title;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String description;

    private String url;

    //private int etat;

    public News() {
    }

    public News(String title, Date date, String description, String url) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.url = url;
    }
}
