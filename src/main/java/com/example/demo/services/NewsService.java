package com.example.demo.services;

import com.example.demo.model.News;
import com.example.demo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.zip.Deflater;
import java.util.List;

@Service
public class NewsService  {

    @Autowired
    private NewsRepository repository;

    public News saveNew (News news)  {
        news.setUrl("../../assets/img/" + news.getUrl());
        return repository.save(news);
    }

    public List<News> getNews()
    {
    return repository.findAll();
    }
    
    public News getNewsById(long id)
    {
        return repository.findById(id).orElse(null);
    }

    public String DeleteNew(long id)
    {
        repository.deleteById(id);
        return "product removed " + id;
    }

    public News updateNewsReq(News news)
    {
        News existingNew = repository.findById(news.getNews_id()).orElse(null);
        existingNew.setTitle(news.getTitle());
        existingNew.setDate(news.getDate());
        existingNew.setDescription(news.getDescription());
        existingNew.setUrl(news.getUrl());
        return repository.save(existingNew);
    }
}
