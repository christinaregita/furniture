/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.dto;

/**
 *
 * @author ACER
 */
public class ApplicantDTO {
    private Integer registrationId;
    private Integer applicantId;
    private String applicantName;
    private String applicantDept;
    private String applicantJob;
    private String statusRegistration;

    public ApplicantDTO() {
    }

    public ApplicantDTO(Integer registrationId, Integer applicantId, String applicantName, String applicantDept, String applicantJob, String statusRegistration) {
        this.registrationId = registrationId;
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.applicantDept = applicantDept;
        this.applicantJob = applicantJob;
        this.statusRegistration = statusRegistration;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantDept() {
        return applicantDept;
    }

    public void setApplicantDept(String applicantDept) {
        this.applicantDept = applicantDept;
    }

    public String getApplicantJob() {
        return applicantJob;
    }

    public void setApplicantJob(String applicantJob) {
        this.applicantJob = applicantJob;
    }

    public String getStatusRegistration() {
        return statusRegistration;
    }

    public void setStatusRegistration(String statusRegistration) {
        this.statusRegistration = statusRegistration;
    }
    
    
    
}
