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
public class CreateEventDTO {
    private int id;
    private String name;
    private String description;
    private String trainer;
    private int quota;
    private String requirement;
    private int point;
    private String categoryId;
    private Date date;
    private String startTime;
    private String endTime;
    private String location;
    private boolean isOnline;

    public CreateEventDTO() {
    }

    public CreateEventDTO(int id, String name, String description, String trainer, int quota, String requirement, int point, String categoryId, Date date, String startTime, String endTime, String location, boolean isOnline) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTrainer() {
        return trainer;
    }

    public int getQuota() {
        return quota;
    }

    public String getRequirement() {
        return requirement;
    }

    public int getPoint() {
        return point;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Date getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }

    public boolean isIsOnline() {
        return isOnline;
    }
    
    
}
