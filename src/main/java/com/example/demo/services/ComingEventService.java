package com.example.demo.services;

import com.example.demo.model.ComingEvent;
import com.example.demo.model.ComingEvent;
import com.example.demo.repository.ComingEventRepository;
import com.example.demo.repository.ComingEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.zip.Deflater;
import java.util.List;

@Service
public class ComingEventService  {

    @Autowired
    private ComingEventRepository repository;

    public ComingEvent saveEvent (ComingEvent event)  {
        event.setUrl("../../assets/img/" + event.getUrl());
        return repository.save(event);
    }

    public List<ComingEvent> getEvents()
    {
        return repository.findAll();
    }

    public ComingEvent getEventById(long id)
    {
        return repository.findById(id).orElse(null);
    }

    public String DeleteEvent(long id)
    {
        repository.deleteById(id);
        return "product removed " + id;
    }

    public ComingEvent updateEventReq(ComingEvent ComingEvent)
    {
        ComingEvent existingNew = repository.findById(ComingEvent.getEvent_id()).orElse(null);
        existingNew.setTitle(ComingEvent.getTitle());
        existingNew.setDate(ComingEvent.getDate());
        existingNew.setDescription(ComingEvent.getDescription());
        existingNew.setUrl(ComingEvent.getUrl());
        return repository.save(existingNew);
    }
}
