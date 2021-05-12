/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.controllers;

import java.util.List;
import mii.co.id.servertrainingmanagement.dto.MyEventDTO;
import mii.co.id.servertrainingmanagement.entities.Registration;
import mii.co.id.servertrainingmanagement.services.MyEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("api/my-event")
public class MyEventController {
    
    @Autowired 
    MyEventService myEventService;
    
    @GetMapping("{id}")
    public List<MyEventDTO> read(@PathVariable Integer id) {
        return myEventService.getById(id);
    }
}
