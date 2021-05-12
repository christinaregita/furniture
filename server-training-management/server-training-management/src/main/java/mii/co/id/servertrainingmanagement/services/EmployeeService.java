/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import java.util.List;
import mii.co.id.servertrainingmanagement.dto.AccountRegisterDto;
import mii.co.id.servertrainingmanagement.entities.Account;
import mii.co.id.servertrainingmanagement.entities.Employee;
import mii.co.id.servertrainingmanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService() {
    }
    
    public Employee getById(Integer id) {
        return employeeRepository.findById(id).get();
    }
    
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
