package com.example.demo.repository;

import com.example.demo.model.InscriptionRequest;
import com.example.demo.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
   //  Optional<News> findByName(String namePic);


}