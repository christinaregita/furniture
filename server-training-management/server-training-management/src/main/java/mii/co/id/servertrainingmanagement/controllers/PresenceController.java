/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.controllers;

import java.util.List;
import mii.co.id.servertrainingmanagement.entities.Presence;
import mii.co.id.servertrainingmanagement.services.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/presence")
public class PresenceController {

    @Autowired
    PresenceService presenceService;
    
    @GetMapping()
    public List<Presence> getAll() {
        System.out.println(presenceService.getAll());
        return presenceService.getAll();
    }
    
    @GetMapping("{id}")
    public Presence getById(@PathVariable Integer id) {
        System.out.println(presenceService.getById(id));
        return presenceService.getById(id);
    }
    
    @PutMapping("/yes/{id}")
    public Presence updatePresenceYes(@PathVariable Integer id){
        System.out.println(presenceService.updateStatusYes(id));
        return presenceService.updateStatusYes(id);
    }
    
    @PutMapping("/no/{id}")
    public Presence updatePresenceNo(@PathVariable Integer id){
        System.out.println(presenceService.updateStatusNo(id));
        return presenceService.updateStatusNo(id);
    }
}
