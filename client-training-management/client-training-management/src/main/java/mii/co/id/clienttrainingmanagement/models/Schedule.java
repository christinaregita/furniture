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
public class Schedule {
    private Integer scheduleId;
    private String date;
    private String startTime;
    private String endTime;
    private String location;
    private Boolean isOnline;

    public Schedule() {
    }

    public Schedule(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.date = schedule.getDate();
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
        this.location = schedule.getLocation();
        this.isOnline = schedule.getIsOnline();
    }
    
    
}
