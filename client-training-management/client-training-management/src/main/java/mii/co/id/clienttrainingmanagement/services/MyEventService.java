/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.services;

import java.util.List;
import mii.co.id.clienttrainingmanagement.config.RequestFormat;
import mii.co.id.clienttrainingmanagement.models.MyEvent;
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
public class MyEventService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/my-event")
    private String url;

    public List<MyEvent> getById(Integer id) {
        ResponseEntity<List<MyEvent>> response = restTemplate
                .exchange(url + "/" + id, HttpMethod.GET,
                        new HttpEntity<>(RequestFormat.createHeader()),
                        new ParameterizedTypeReference<List<MyEvent>>() {
                });
        return response.getBody();
    }
}
