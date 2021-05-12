/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.services;

import java.util.List;
import mii.co.id.clienttrainingmanagement.config.RequestFormat;
import mii.co.id.clienttrainingmanagement.models.Leaderboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ASUS
 */
@Service
public class LeaderboardService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/api/leaderboard")
    private String url;
    
    public List<Leaderboard> getAll() {
        ResponseEntity<List<Leaderboard>> response = restTemplate
                .exchange(url, HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeader()),
                        new ParameterizedTypeReference<List<Leaderboard>>() {
                });
        return response.getBody();
    }
}
