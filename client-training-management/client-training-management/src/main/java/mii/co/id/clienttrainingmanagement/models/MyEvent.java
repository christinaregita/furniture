/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.models;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class MyEvent {
    private Integer id;
    private String eventName;
    private String date;
    private String startTime;
    private String status;
    private Integer point;

    public MyEvent() {
    }

    public MyEvent(Integer id, String eventName, String date, String startTime, String status, Integer point) {
        this.id = id;
        this.eventName = eventName;
        this.date = date;
        this.startTime = startTime;
        this.status = status;
        this.point = point;
    }

    

    

    
    
    
}
