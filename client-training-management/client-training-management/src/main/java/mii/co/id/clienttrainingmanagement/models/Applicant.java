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
public class Applicant {
    private Integer registrationId;
    private Integer applicantId;
    private String applicantName;
    private String applicantDept;
    private String applicantJob;
    private String statusRegistration;

    public Applicant() {
    }

    public Applicant(Integer registrationId, Integer applicantId, String applicantName, String applicantDept, String applicantJob, String statusRegistration) {
        this.registrationId = registrationId;
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.applicantDept = applicantDept;
        this.applicantJob = applicantJob;
        this.statusRegistration = statusRegistration;
    }
    
    
}
