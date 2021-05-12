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
public class Registration {
    private Integer id;
    private String date;
    private Presence presence;
    private Employee employee;
    private Event event;
    private StatusRegistration statusRegistration;

    public Registration() {
    }

    public Registration(Integer id, String date, Presence presence, Employee employee, Event event, StatusRegistration statusRegistration) {
        this.id = id;
        this.date = date;
        this.presence = presence;
        this.employee = employee;
        this.event = event;
        this.statusRegistration = statusRegistration;
    }
    
}
