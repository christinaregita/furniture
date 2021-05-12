/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.controllers;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.clienttrainingmanagement.models.Applicant;
import mii.co.id.clienttrainingmanagement.models.Event;
import mii.co.id.clienttrainingmanagement.models.EventRequest;
import mii.co.id.clienttrainingmanagement.models.Registration;
import mii.co.id.clienttrainingmanagement.models.StatusRegistration;
import mii.co.id.clienttrainingmanagement.services.CategoryService;
import mii.co.id.clienttrainingmanagement.services.EventService;
import mii.co.id.clienttrainingmanagement.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/catalog")
public class EventController {
    
    @Autowired
    private EventService eventService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private RegistrationService registrationService;
    
    @GetMapping
    public String getAll(Model model, @ModelAttribute("eventId") Event eventId) {
        model.addAttribute("event", eventService.getAllOpen());
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userId", authent.getPrincipal());
        model.addAttribute("category", categoryService.getAll());
        return "catalog";
    }
    
    @GetMapping("/get-all")
    public @ResponseBody List<Event> getAllProcess() {
        List<Event> eventList = eventService.getAllOpen();
        for(Event e : eventList) {
            e.setCountPendingApp(eventService.getApplicants(e.getId()).size());
        }
        return eventList;
    }

    @GetMapping("/{id}")
    public @ResponseBody Event getById(@PathVariable("id") Integer id) {
        return eventService.getById(id);
    }

    @PostMapping
    public @ResponseBody Event createEvent(@RequestBody EventRequest event) {
        return eventService.create(event);
    }
     

    @PutMapping("/{id}")
    public @ResponseBody Event update(@PathVariable("id") Integer id, @RequestBody Event event) {
        return eventService.update(id, event);
    }
    
    @DeleteMapping("/{id}")
    public @ResponseBody Event delete(@PathVariable("id") Integer id) {
        return eventService.softDelete(id);
    }
    

    @GetMapping("/applicant/{id}/get-all")
    public @ResponseBody List<Applicant> getApplicantsProcess(@PathVariable Integer id) {
        return eventService.getApplicants(id);
    }
    
    @GetMapping("/applicant/{id}")
    public String getApplicants(@PathVariable Integer id, Model model) {
        model.addAttribute("eventId", id);
        return "applicant";
    }
    
    @PutMapping("/applicant/registration/{id}")
    public @ResponseBody Registration update(@PathVariable("id") Integer id, 
                                            @RequestBody StatusRegistration statusRegistration) {
        return registrationService.update(id, statusRegistration);
    }
}
