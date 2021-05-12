/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.models;

import java.util.List;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class AuthResponse {
    private Integer id;
    private String name;
    private List<String> authorities;

    public AuthResponse(Integer id, String name, List<String> authorities) {
        this.id = id;
        this.name = name;
        this.authorities = authorities;
    }

    public AuthResponse() {
    }
    
    
}
