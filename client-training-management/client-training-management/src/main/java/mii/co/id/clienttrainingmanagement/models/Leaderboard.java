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
public class Leaderboard {
    private Integer employeeId;
    private String employeeName;
    private Integer point;

    public Leaderboard() {
    }

    public Leaderboard(Leaderboard leaderboard) {
        this.employeeId = leaderboard.getEmployeeId();
        this.employeeName = leaderboard.getEmployeeName();
        this.point = leaderboard.getPoint();
    }
    
    
}
