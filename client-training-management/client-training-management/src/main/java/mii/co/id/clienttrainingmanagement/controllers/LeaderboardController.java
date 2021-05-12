/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.controllers;

import java.util.List;
import mii.co.id.clienttrainingmanagement.models.Leaderboard;
import mii.co.id.clienttrainingmanagement.services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/leaderboard")
public class LeaderboardController {
    
    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("leaderboard", leaderboardService.getAll());
        return "leaderboard";
    }

    @GetMapping("/get-all")
    public @ResponseBody List<Leaderboard> getAllProcess() {
        System.out.println(leaderboardService.getAll());
        return leaderboardService.getAll();
    }
    
}
