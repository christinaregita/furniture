/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import java.util.List;
import mii.co.id.servertrainingmanagement.entities.Category;
import mii.co.id.servertrainingmanagement.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService() {
    }
    
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
