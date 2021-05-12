/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.servertrainingmanagement.dto.LeaderboardDTO;
import mii.co.id.servertrainingmanagement.entities.Employee;
import mii.co.id.servertrainingmanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class LeaderboardService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    public List<LeaderboardDTO> getAll() {
        employeeRepository.findAll();
        List<LeaderboardDTO> ldtos = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            LeaderboardDTO ldto = new LeaderboardDTO(
                    e.getId(),
                    e.getName(),
                    e.getAccount().getPoint());
            ldtos.add(ldto);
        }
        return ldtos;
    }
}
