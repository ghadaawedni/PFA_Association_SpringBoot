package com.example.demo.controller;

import com.example.demo.model.ComingEvent;
import com.example.demo.services.ComingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*" )
@RequestMapping("/ComingEvent")
public class ComingEventAPIs {


    @Autowired
    private ComingEventService service;


    @PostMapping("/addEvent")
    @PreAuthorize("hasRole('ADMIN')")
    public ComingEvent addEventReq(@RequestBody ComingEvent ComingEvent)
    {
        return service.saveEvent(ComingEvent);
    }

    @GetMapping("/getComingEvent")
    public List<ComingEvent> getAllEvents()
    {
        return service.getEvents();
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ComingEvent updateEvent(@RequestBody ComingEvent event)
    {
        return service.updateEventReq(event);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> DeleteEvent(@PathVariable long id)
    {   service.DeleteEvent(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Success", "OK");
        return ResponseEntity.accepted().build();
    }
}
