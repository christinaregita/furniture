/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.services;

import java.util.List;
import java.util.stream.Collectors;
import mii.co.id.clienttrainingmanagement.config.RestTemplateConfig;
import mii.co.id.clienttrainingmanagement.models.AuthRequest;
import mii.co.id.clienttrainingmanagement.models.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ASUS
 */
@Service
public class AuthService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    @Value("${api.url}/login")
    private String url;
    
    public boolean loginProcess(AuthRequest request) {
        boolean isLoginSuccess = false;
        try {
            HttpEntity entity = new HttpEntity(request);
            ResponseEntity<AuthResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity,
                    new ParameterizedTypeReference<AuthResponse>() {
            });
            /*panggil method untuk set spring security session*/
            setAuthorization(response.getBody().getId(), request.getUsername(), request.getPassword(),
                    response.getBody().getAuthorities());

            isLoginSuccess = true;

        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return isLoginSuccess;
    }

    /*Method untuk mengeset spring security session*/
    private void setAuthorization(Integer id, String userName, String userPassword, List<String> authorities) {
        UsernamePasswordAuthenticationToken authToken
                = new UsernamePasswordAuthenticationToken(id, userPassword, getListAuthorities(authorities));
        authToken.setDetails(userName);

        SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    /*List dari authorities*/
    private List<GrantedAuthority> getListAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(auth -> new SimpleGrantedAuthority(auth))
                .collect(Collectors.toList());
    }
}
