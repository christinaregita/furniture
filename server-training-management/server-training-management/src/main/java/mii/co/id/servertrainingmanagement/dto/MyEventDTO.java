/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.dto;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class MyEventDTO {
    private int id;
    private String eventName;
    private Date date;
    private Date startTime;
    private String status;
    private int point;

    public MyEventDTO() {
    }

    public MyEventDTO(int id, String eventName, Date date, Date startTime, String status, int point) {
        this.id = id;
        this.eventName = eventName;
        this.date = date;
        this.startTime = startTime;
        this.status = status;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getDate() {
        return date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getStatus() {
        return status;
    }

    public int getPoint() {
        return point;
    }

    
    
    
}
