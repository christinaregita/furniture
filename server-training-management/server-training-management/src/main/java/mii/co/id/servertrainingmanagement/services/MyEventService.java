/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.servertrainingmanagement.dto.MyEventDTO;
import mii.co.id.servertrainingmanagement.entities.Employee;
import mii.co.id.servertrainingmanagement.entities.Event;
import mii.co.id.servertrainingmanagement.entities.Registration;
import mii.co.id.servertrainingmanagement.repositories.EmployeeRepository;
import mii.co.id.servertrainingmanagement.repositories.EventRepository;
import mii.co.id.servertrainingmanagement.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class MyEventService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    public List<MyEventDTO> getById(Integer id) {
        List<MyEventDTO> eventDTOs = new ArrayList<>();
        for (Registration e : registrationRepository.findAll()) {
            if (id == e.getEmployee().getId()) {

                MyEventDTO eventDTO = new MyEventDTO(
                        e.getEmployee().getId(),
                        e.getEvent().getName(),
                        e.getEvent().getSchedule().getDate(),
                        e.getEvent().getSchedule().getStartTime(),
                        e.getStatusRegistration().getName(),
                        e.getEvent().getPoint());
                eventDTOs.add(eventDTO);
            }
        }
        return eventDTOs;
//        return registrationRepository.findAll();
    }
}
