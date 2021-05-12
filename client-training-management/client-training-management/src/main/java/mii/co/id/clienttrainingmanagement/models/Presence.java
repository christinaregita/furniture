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
public class Presence {
    private Integer presenceId;
    private String approvedName;
    private String approvedDept;
    private String statusPresence;
    

    public Presence() {
    }

    public Presence(Integer presenceId, String approvedName, String approvedDept, String statusPresence) {
        this.presenceId = presenceId;
        this.approvedName = approvedName;
        this.approvedDept = approvedDept;
        this.statusPresence = statusPresence;
    }

    


}
