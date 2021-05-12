/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.services;

import java.util.List;
import mii.co.id.clienttrainingmanagement.config.RequestFormat;
import mii.co.id.clienttrainingmanagement.models.EventHistory;
import mii.co.id.clienttrainingmanagement.models.Presence;
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
 * @author Asus
 */
@Service
public class PresenceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/presence")
    private String url;

    public List<Presence> getAllByEventId(Integer eventId) {
        ResponseEntity<List<Presence>> response = restTemplate
                .exchange(url, HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeader()),
                        new ParameterizedTypeReference<List<Presence>>() {
                });
        return response.getBody();
    }
    
    //UPDATE presence -> yes
    public Presence updateYes(Integer id) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeader());
        ResponseEntity<Presence> res = restTemplate.exchange(url + "/yes/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<Presence>() {
        });
        return res.getBody();
    }
    
    //UPDATE presence -> no
    public Presence updateNo(Integer id) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeader());
        ResponseEntity<Presence> res = restTemplate.exchange(url + "/no/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<Presence>() {
        });
        return res.getBody();
    }
}
