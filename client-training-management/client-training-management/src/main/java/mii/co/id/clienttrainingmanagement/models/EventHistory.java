/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clienttrainingmanagement.models;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class EventHistory {

    private Integer history_event_id;
    private String event;
    private Date date;
    private String status_event;
    private String presensi;

    public EventHistory() {

    }

    public EventHistory(EventHistory history_event) {
        this.history_event_id = history_event.getHistory_event_id();
        this.event = history_event.getEvent();
        this.date = history_event.getDate();
        this.status_event = history_event.getStatus_event();
        this.presensi = history_event.getPresensi();
    }
}
