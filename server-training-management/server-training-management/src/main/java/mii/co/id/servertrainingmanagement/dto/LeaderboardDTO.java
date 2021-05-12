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
public class LeaderboardDTO {
    private int employeeId;
    private String employeeName;
    private int point;

    public LeaderboardDTO() {
    }

    public LeaderboardDTO(int employeeId, String employeeName, int point) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.point = point;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getPoint() {
        return point;
    }
    
    
}
