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
public class Job {
    private Integer id;
    private String name;

    public Job() {
    }

    public Job(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
}
