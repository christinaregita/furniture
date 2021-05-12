/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.models;

import lombok.Data;

/**
 *
 * @author ACER
 */
@Data
public class EventRequest {
   private Integer id;
    private String name;
    private String description;
    private String trainer;
    private Integer quota;
    private String requirement;
    private Integer point;
    private Integer categoryId;
    private String date;
    private String startTime;
    private String endTime;
    private String location;
    private Boolean isOnline;  

    public EventRequest() {
    }

    public EventRequest(Integer id, String name, String desc, String trainer, Integer quota, String requirement, Integer point, Integer categoryId, String date, String startTime, String endTime, String location, Boolean isOnline) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.trainer = trainer;
        this.quota = quota;
        this.requirement = requirement;
        this.point = point;
        this.categoryId = categoryId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.isOnline = isOnline;
    }
}
