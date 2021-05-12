/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.dto;

import java.util.List;
import mii.co.id.servertrainingmanagement.entities.Privilege;
import mii.co.id.servertrainingmanagement.entities.Role;

/**
 *
 * @author ACER
 */
public class LoginResponseDto {
    private Integer id;
    private String name;
    private List<String> authorities;

    public LoginResponseDto() {
    }

    public LoginResponseDto(Integer id, String name, List<String> authorities) {
        this.id = id;
        this.name = name;
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    
}
