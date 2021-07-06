package com.example.demo.repository;

import com.example.demo.model.InscriptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionReqRepository extends JpaRepository<InscriptionRequest,Long> {
    InscriptionRequest findByFirstName (String firstName);
}
