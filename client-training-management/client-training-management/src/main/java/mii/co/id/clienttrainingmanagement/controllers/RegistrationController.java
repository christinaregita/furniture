/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.controllers;

import mii.co.id.clienttrainingmanagement.models.Registration;
import mii.co.id.clienttrainingmanagement.models.RegistrationRequest;
import mii.co.id.clienttrainingmanagement.models.StatusRegistration;
import mii.co.id.clienttrainingmanagement.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/registration")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;
    
    @PostMapping
    public @ResponseBody Registration createEvent(@RequestBody RegistrationRequest registration) {
        System.out.println(registration);
        return registrationService.create(registration);
    }
    
//    @PutMapping("/{id}")
//    public @ResponseBody Registration update(@PathVariable("id") Integer id, 
//                                            @RequestBody StatusRegistration statusRegistration) {
////        System.out.println(statusRegistration.getName());
//        return registrationService.update(id, statusRegistration);
//    }
}
