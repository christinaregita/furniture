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
public class Category {
    private Integer id;
    private String name;

    public Category() {
    }

    public Category(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
    
    
}
