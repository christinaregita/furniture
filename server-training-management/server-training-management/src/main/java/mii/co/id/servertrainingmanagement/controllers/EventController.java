/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.controllers;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import javax.mail.MessagingException;
import mii.co.id.servertrainingmanagement.dto.ApplicantDTO;
import mii.co.id.servertrainingmanagement.dto.EventRequestDTO;
import mii.co.id.servertrainingmanagement.dto.PresenceDTO;
import mii.co.id.servertrainingmanagement.entities.Event;
import mii.co.id.servertrainingmanagement.entities.Registration;
import mii.co.id.servertrainingmanagement.services.EventService;
import mii.co.id.servertrainingmanagement.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("api/event")
public class EventController {
    
    @Autowired
    EventService eventService;
    
    @Autowired
    NotificationService notificationService;

    public EventController() {
    }
    
    @GetMapping("/{id}")
    public Event getById(@PathVariable Integer id) {
        return eventService.getById(id);
    }
    
    @GetMapping("")
    public List<Event> getAll() {
        return eventService.getAll();
    }
    
    @GetMapping("/open")
    public List<Event> getAllOpen() {
        return eventService.getAllOpen();
    }
    
    @GetMapping("/not-open")
    public List<Event> getAllNotOpen() {
        return eventService.getAllNotOpen();
    }
    
    @PostMapping()
    public Event create(@RequestBody EventRequestDTO requestDTO) throws ParseException {
        return eventService.create(requestDTO);
    }
    
    @PutMapping("/{id}")
    public Event update(@PathVariable Integer id, @RequestBody Event event, Locale locale) throws MessagingException {
        List<Registration> registrationList = eventService.getById(id).getRegistrationList();
        for(Registration r:registrationList){
            notificationService.sendEmailHTML(r.getEmployee().getId(), r, locale, "email-update");
        }
        return eventService.update(id, event);
    }
    
    @DeleteMapping("/{id}")
    public Event softDelete(@PathVariable Integer id, Locale locale) throws MessagingException {
        List<Registration> registrationList = eventService.getById(id).getRegistrationList();
        for(Registration r:registrationList){
            notificationService.sendEmailHTML(r.getEmployee().getId(), r, locale, "email-cancelled");
        }
        return eventService.softDelete(id);
    }
    
//    @GetMapping("/submission/{eventId}")
//    public List<Registration> getSubmission(@PathVariable Integer eventId) {
//        return eventService.getSubmission(eventId);
//    }
    
    @GetMapping("/{eventId}/applicant")
    public List<ApplicantDTO> getApplicants(@PathVariable Integer eventId) {
        return eventService.getApplicants(eventId);
    }
    
    @GetMapping("/presence/{eventId}")
    public List<PresenceDTO> getPresences(@PathVariable Integer eventId) {
        return eventService.getPresences(eventId);
    }
}
