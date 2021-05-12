/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.services;

import java.util.List;
import mii.co.id.clienttrainingmanagement.config.RequestFormat;
import mii.co.id.clienttrainingmanagement.models.Employee;
import mii.co.id.clienttrainingmanagement.models.Event;
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
 * @author ACER
 */
@Service
public class ProfileService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/api/employee")
    private String url;
    
    public Employee getProfileById(Integer id) {
        ResponseEntity<Employee> response = restTemplate
                .exchange(url + "/" + id, HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeader()),
                        new ParameterizedTypeReference<Employee>() {
                });
        return response.getBody();
    }
    
//    public String getById (Integer id){
//        ResponseEntity<Employee> response = restTemplate
//                .exchange(url + "/" + id, HttpMethod.GET,
//                        new HttpEntity(RequestFormat.createHeader()),
//                        new ParameterizedTypeReference<Employee>() {
//                });
//        return response.getBody().getName();
//    }
    
}
