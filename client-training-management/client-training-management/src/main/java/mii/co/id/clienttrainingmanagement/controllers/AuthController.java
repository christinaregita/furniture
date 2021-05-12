/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.controllers;

import mii.co.id.clienttrainingmanagement.models.AuthRequest;
import mii.co.id.clienttrainingmanagement.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        AuthRequest auth = new AuthRequest();
        model.addAttribute("auth", auth);
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authent);
        if (authent == null || authent instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute("auth") AuthRequest auth) {
        String redirectURL = "";

        if (authService.loginProcess(auth)) {
//            Authentication authent = SecurityContextHolder.getContext().getAuthentication();
//            System.out.println(authent);
            redirectURL = "redirect:/home";
        } else {
            redirectURL = "redirect:/login?error";
        }
        return redirectURL;
    }

    @GetMapping("/home")
    public String catalog() {
//        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authent);
        return "home";
    }

//    @GetMapping("/myevent")
//    public String myevent() {
//        return "myevent";
//    }
//
//    @GetMapping("/historyevent")
//    public String historyevent() {
//        return "historyevent";
//    }
//
//    @GetMapping("/profile")
//    public String profile() {
//        return "profile";
//    }
    
    @GetMapping("/userId")
    public @ResponseBody String getUserId() {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authent);
        return authent.getPrincipal().toString();
    }

}
