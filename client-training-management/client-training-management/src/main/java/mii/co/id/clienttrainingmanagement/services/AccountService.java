/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.services;

import mii.co.id.clienttrainingmanagement.config.RequestFormat;
import mii.co.id.clienttrainingmanagement.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ACER
 */
@Service
public class AccountService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    @Value("${api.url}/account")
    private String url;
    
    public Integer getIdByUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        HttpEntity entity = new HttpEntity(RequestFormat.createHeader());
        ResponseEntity<Integer> res = restTemplate.exchange(url + username, HttpMethod.GET, entity,
                new ParameterizedTypeReference<Integer>() {
        });
        return res.getBody();
    }
}
