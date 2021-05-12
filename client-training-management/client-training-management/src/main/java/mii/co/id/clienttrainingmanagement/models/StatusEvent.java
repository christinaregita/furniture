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
public class StatusEvent {
    private Integer id;
    private String name;

    public StatusEvent() {
    }

    public StatusEvent(StatusEvent statusEvent) {
        this.id = statusEvent.getId();
        this.name = statusEvent.getName();
    }
    
    
}
