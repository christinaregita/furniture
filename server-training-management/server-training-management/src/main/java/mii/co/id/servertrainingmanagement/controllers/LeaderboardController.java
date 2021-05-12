/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.controllers;

import java.util.List;
import mii.co.id.servertrainingmanagement.dto.LeaderboardDTO;
import mii.co.id.servertrainingmanagement.services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("api/leaderboard")
public class LeaderboardController {
    
    @Autowired
    private LeaderboardService leaderboardService;
    
    @GetMapping("")
    public List<LeaderboardDTO> read() {
        return leaderboardService.getAll();
    }
}
