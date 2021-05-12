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
public class RegistrationRequest {
    private Integer id;
    private Employee employee;
    private Event event;

    public RegistrationRequest() {
    }

    public RegistrationRequest(Integer id, Employee employee, Event event) {
        this.id = id;
        this.employee = employee;
        this.event = event;
    }
    
}
