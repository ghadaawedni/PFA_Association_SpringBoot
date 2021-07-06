package com.example.demo.controller;

import com.example.demo.model.News;
import com.example.demo.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
@RequestMapping("/news")
public class NewsAPIs {


    @Autowired
    private NewsService service;
    @PostMapping("/addNew")
    @PreAuthorize("hasRole('ADMIN')")
    public News addNewsReq(@RequestBody News news)
    {
       // news.setEtat(0);
        return service.saveNew(news);
    }

    @GetMapping("/getNews")
    public List<News> getAllNews()
    {
        return service.getNews();
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public News updateNew(@RequestBody News news)
    {
        return service.updateNewsReq(news);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<Void> deleteNew(@PathVariable long id)
    {   service.DeleteNew(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Success", "OK");
        return ResponseEntity.accepted().build();
    }

}
