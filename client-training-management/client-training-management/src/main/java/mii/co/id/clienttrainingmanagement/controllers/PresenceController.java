///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package mii.co.id.clienttrainingmanagement.controllers;
//
//import java.util.List;
//import mii.co.id.clienttrainingmanagement.models.Event;
//import mii.co.id.clienttrainingmanagement.services.EventService;
//import mii.co.id.clienttrainingmanagement.services.PresenceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// *
// * @author Asus
// */
//@Controller
//public class PresenceController {
//
//    @Autowired
//    private PresenceService presenceService;
//
//    public PresenceController() {
//    }
//
//    @GetMapping
//    public String getAll() {
////        model.addAttribute("eventhistory", eventService.getAll());
//        return "presence";
//    }
//
//    @GetMapping("/get-all")
//    public @ResponseBody
//    List<Event> getAllProcess() {
//        System.out.println(presenceService.getAll());
//        return presenceService.getAll();
//    }
//}
