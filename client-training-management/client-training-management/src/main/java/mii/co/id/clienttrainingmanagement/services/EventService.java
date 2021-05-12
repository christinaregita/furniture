/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.services;

import java.util.List;
import mii.co.id.clienttrainingmanagement.config.RequestFormat;
import mii.co.id.clienttrainingmanagement.models.Applicant;
import mii.co.id.clienttrainingmanagement.models.Event;
import mii.co.id.clienttrainingmanagement.models.EventRequest;
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
 * @author ASUS
 */
@Service
public class EventService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/event")
    private String url;

    //READ EVENT WHICH STATUS OPEN
    public List<Event> getAllOpen() {
        ResponseEntity<List<Event>> response = restTemplate
                .exchange(url + "/open", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeader()),
                        new ParameterizedTypeReference<List<Event>>() {
                });
        return response.getBody();
    }

    //READ EVENT WHICH STATUS CLOSE, DONE, OR CANCELLED
    public List<Event> getAllNotOpen() {
        ResponseEntity<List<Event>> response = restTemplate
                .exchange(url + "/not-open", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeader()),
                        new ParameterizedTypeReference<List<Event>>() {
                });
        return response.getBody();
    }

    //GET BY ID
    public Event getById(Integer id) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeader());
        ResponseEntity<Event> res = restTemplate.exchange(url + "/" + id, HttpMethod.GET, entity,
                new ParameterizedTypeReference<Event>() {
        });
        return res.getBody();
//        return restTemplate.getForEntity(url + "/" + id, District.class).getBody();
    }

    //CREATE 
    public Event create(EventRequest event) {
        HttpEntity entity = new HttpEntity(event, RequestFormat.createHeader());
        ResponseEntity<Event> res = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<Event>() {
        });
        return res.getBody();
    }

    //UPDATE
    public Event update(Integer id, Event event) {
        HttpEntity entity = new HttpEntity(event, RequestFormat.createHeader());
        ResponseEntity<Event> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<Event>() {
        });
        return res.getBody();
    }

    //DELETE
    public Event softDelete(Integer id) {
        HttpEntity entity = new HttpEntity(id, RequestFormat.createHeader());
        ResponseEntity<Event> res = restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, entity,
                new ParameterizedTypeReference<Event>() {
        });
        return res.getBody();
    }

    //Get applicants of event
    public List<Applicant> getApplicants(Integer eventId) {
        HttpEntity entity = new HttpEntity(eventId, RequestFormat.createHeader());
        ResponseEntity<List<Applicant>> res = restTemplate.exchange(url + "/" + eventId + "/applicant", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Applicant>>() {
        });
        return res.getBody();
    }

    //Get applicants of event
    public List<Presence> getPresences(Integer eventId) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeader());
        ResponseEntity<List<Presence>> res = restTemplate.exchange(url + "/presence/" + eventId, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Presence>>() {
        });
        System.out.println(eventId);
        System.out.println(res.getBody());
        return res.getBody();
    }
}
