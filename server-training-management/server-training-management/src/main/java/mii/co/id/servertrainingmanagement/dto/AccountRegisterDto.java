/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.dto;

/**
 *
 * @author ACER
 */
public class AccountRegisterDto {
    private Integer id;
    private String email;
    private String password;

    public AccountRegisterDto(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public AccountRegisterDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
