package mii.co.id.clienttrainingmanagement.services;

import java.util.List;
import mii.co.id.clienttrainingmanagement.config.RequestFormat;
import mii.co.id.clienttrainingmanagement.models.EventHistory;
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
public class EventHistoryService {
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.url}/api/eventhistory")
    private String url;
    
    public List<EventHistory> getAll() {
        ResponseEntity<List<EventHistory>> response = restTemplate
                .exchange(url, HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeader()),
                        new ParameterizedTypeReference<List<EventHistory>>() {
                });
        return response.getBody();
    }
}
