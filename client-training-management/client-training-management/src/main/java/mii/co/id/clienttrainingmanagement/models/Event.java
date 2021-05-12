/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.models;

import java.util.List;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class Event {
    private Integer id;
    private String name;
    private String description;
    private String trainer;
    private Integer quota;
    private Integer applicant;
    private String requirement;
    private Integer point;
    private Category category;
    private Schedule schedule;
    private StatusEvent statusEvent;
    private Integer countPendingApp;

    public Event() {
    }

    public Event(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.trainer = event.getTrainer();
        this.quota = event.getQuota();
        this.applicant = event.getApplicant();
        this.requirement = event.getRequirement();
        this.point = event.getPoint();
        this.category = event.getCategory();
        this.schedule = event.getSchedule();
        this.statusEvent = event.getStatusEvent();
        this.countPendingApp = event.getCountPendingApp();
    }
    
    
}
