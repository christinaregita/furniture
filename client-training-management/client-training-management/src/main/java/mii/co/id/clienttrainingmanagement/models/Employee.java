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
public class Employee {
    private Integer id;
    private String name;
    private String gender;
    private String hireDate;
    private Department department;
    private Job job;

    public Employee() {
    }

    public Employee(Integer id, String name, String gender, String hireDate, Department department, Job job) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.hireDate = hireDate;
        this.department = department;
        this.job = job;
    }
    
    
}
