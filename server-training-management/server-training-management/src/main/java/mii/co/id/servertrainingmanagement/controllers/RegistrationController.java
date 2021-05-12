/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.controllers;

import java.util.List;
import java.util.Locale;
import javax.mail.MessagingException;
import mii.co.id.servertrainingmanagement.entities.Registration;
import mii.co.id.servertrainingmanagement.entities.StatusRegistration;
import mii.co.id.servertrainingmanagement.services.NotificationService;
import mii.co.id.servertrainingmanagement.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@RequestMapping("/api/registration")
public class RegistrationController {
    
    @Autowired
    RegistrationService registrationService;
    
    @Autowired
    NotificationService notificationService;

    public RegistrationController() {
    }
    
    @GetMapping("/{id}")
    public Registration getById(@PathVariable Integer id) {
        return registrationService.getById(id);
    }
    
    @GetMapping("")
    public List<Registration> getAll() {
        return registrationService.getAll();
    }
    
    @PostMapping("")
    public Registration create(@RequestBody Registration registration, Locale locale) throws MessagingException {
        Registration r = registrationService.create(registration);
        
        notificationService.sendEmailHTML(r.getEmployee().getId(), r, locale, "email-registration");
        return r;
    }
    
    @PutMapping("/{id}")
    public Registration updateStatus(@PathVariable Integer id, @RequestBody StatusRegistration status, Locale locale) throws MessagingException {
        Registration r = registrationService.getById(id);
        if(status.getId()==2) {
            notificationService.sendEmailHTML(r.getEmployee().getId(), r, locale, "email-approved");
        }
        else if(status.getId()==3) {
            notificationService.sendEmailHTML(r.getEmployee().getId(), r, locale, "email-rejected");
        };
        return registrationService.updateStatus(id, status);
    }
}
