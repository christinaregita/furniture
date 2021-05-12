/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.dto;

/**
 *
 * @author ASUS
 */
public class PresenceDTO {
    private Integer presenceId;
    private String approvedName;
    private String approvedDept;
    private StatusPresence statusPresence;

    public PresenceDTO() {
    }

    public PresenceDTO(Integer presenceId, String approvedName, String approvedDept, StatusPresence statusPresence) {
        this.presenceId = presenceId;
        this.approvedName = approvedName;
        this.approvedDept = approvedDept;
        this.statusPresence = statusPresence;
    }

    public Integer getPresenceId() {
        return presenceId;
    }

    public String getApprovedName() {
        return approvedName;
    }

    public String getApprovedDept() {
        return approvedDept;
    }

    public StatusPresence getStatusPresence() {
        return statusPresence;
    }
    
    
}
