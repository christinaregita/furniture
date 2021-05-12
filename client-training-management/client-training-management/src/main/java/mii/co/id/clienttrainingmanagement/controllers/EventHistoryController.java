/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.controllers;

import java.util.List;
import mii.co.id.clienttrainingmanagement.models.Event;
import mii.co.id.clienttrainingmanagement.models.EventHistory;
import mii.co.id.clienttrainingmanagement.models.Leaderboard;
import mii.co.id.clienttrainingmanagement.models.Presence;

import mii.co.id.clienttrainingmanagement.services.EventService;
import mii.co.id.clienttrainingmanagement.services.LeaderboardService;
import mii.co.id.clienttrainingmanagement.services.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/eventhistory")
public class EventHistoryController {
    @Autowired
    private EventService eventService;
    
    @Autowired
    private PresenceService presenceService;

    public EventHistoryController() {
    }

    @GetMapping
    public String getAll() {
//        model.addAttribute("eventhistory", eventService.getAll());
        return "eventhistory";
    }

    @GetMapping("/get-all")
    public @ResponseBody List<Event> getAllProcess() {
        System.out.println(eventService.getAllNotOpen());
        return eventService.getAllNotOpen();
    }
    
    @GetMapping("/presence/get-all/{id}")
    public @ResponseBody List<Presence> getPresenceProcess(@PathVariable Integer id) {
        System.out.println(eventService.getPresences(id));
        return eventService.getPresences(id);
    }
    
    @GetMapping("/presence/{id}")
    public String getPresence(@PathVariable Integer id, Model model) {
        model.addAttribute("eventId", id);
        System.out.println(id); 
        return "presence";
    }
    
    @PutMapping("presence/yes/{id}")
    public @ResponseBody Presence updateYes(@PathVariable("id") Integer id) {
        System.out.println(presenceService.updateYes(id));
        return presenceService.updateYes(id);
    }
    
    @PutMapping("presence/no/{id}")
    public @ResponseBody Presence updateNo(@PathVariable("id") Integer id) {
        return presenceService.updateNo(id);
    }
}
