/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.controllers;

import java.util.List;
import mii.co.id.clienttrainingmanagement.models.MyEvent;
import mii.co.id.clienttrainingmanagement.services.MyEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/myevent")
public class MyEventController {
    
    @Autowired
    private MyEventService myEventService;
    
    @GetMapping
    public String getById(Model model) {
//        model.addAttribute("myEvent", myEventService.getById());
        return "my-event";
    }

    @GetMapping("{id}")
    public @ResponseBody List<MyEvent> getAllById(@PathVariable Integer id) {
        System.out.println(myEventService.getById(id));
        return myEventService.getById(id);
    }
}
