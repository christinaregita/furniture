/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.models;

import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class AuthRequest {
    private String username;
    private String password;

    public AuthRequest(String userName, String userPassword) {
        this.username = userName;
        this.password = userPassword;
    }

    public AuthRequest() {
    }
}
