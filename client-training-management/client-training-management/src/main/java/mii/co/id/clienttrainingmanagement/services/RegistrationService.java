/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.services;

import mii.co.id.clienttrainingmanagement.config.RequestFormat;
import mii.co.id.clienttrainingmanagement.models.Registration;
import mii.co.id.clienttrainingmanagement.models.RegistrationRequest;
import mii.co.id.clienttrainingmanagement.models.StatusRegistration;
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
public class RegistrationService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/api/registration")
    private String url;
    
    //CREATE 
    public Registration create(RegistrationRequest registration) {
        HttpEntity entity = new HttpEntity(registration, RequestFormat.createHeader());
        ResponseEntity<Registration> res = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Registration>() {
        });
        return res.getBody();
    }
    
    //UPDATE
    public Registration update(Integer id, StatusRegistration statusRegistration) {
        HttpEntity entity = new HttpEntity(statusRegistration, RequestFormat.createHeader());
        ResponseEntity<Registration> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<Registration>() {
        });
        return res.getBody();
    }
}
