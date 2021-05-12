/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.controllers;

import mii.co.id.clienttrainingmanagement.models.Employee;
import mii.co.id.clienttrainingmanagement.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/name")
    public @ResponseBody
    String getName() {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        Integer id = (Integer) authent.getPrincipal();
        return profileService.getProfileById(id).getName();
    }

//    @GetMapping("/{id}")
//    public String getProfile(@PathVariable Integer id) {
//        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
//        Integer id = (Integer) authent.getPrincipal();
//        return "profile";
//    }
    @GetMapping
    public String getAll(Model model) {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        Integer id = (Integer) authent.getPrincipal();
        model.addAttribute("employee", profileService.getProfileById(id));
        return "profile";
    }

    @GetMapping("/get-all")
    public @ResponseBody
    Employee getProfileProcess() {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        Integer id = (Integer) authent.getPrincipal();
        return profileService.getProfileById(id);
    }
}
