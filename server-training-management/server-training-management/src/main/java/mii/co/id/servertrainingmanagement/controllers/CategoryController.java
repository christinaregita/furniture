/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.controllers;

import java.util.List;
import mii.co.id.servertrainingmanagement.entities.Category;
import mii.co.id.servertrainingmanagement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;
    
    @GetMapping("")
    public List<Category> getAll() {
        return categoryService.getAll();
    }
}
