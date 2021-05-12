/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import mii.co.id.servertrainingmanagement.entities.Registration;
import mii.co.id.servertrainingmanagement.entities.StatusRegistration;
import mii.co.id.servertrainingmanagement.repositories.EmployeeRepository;
import mii.co.id.servertrainingmanagement.repositories.EventRepository;
import mii.co.id.servertrainingmanagement.repositories.RegistrationRepository;
import mii.co.id.servertrainingmanagement.repositories.StatusRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class RegistrationService {
    
    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    StatusRegistrationRepository statusRegistrationRepository;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    EventRepository eventRepository;
    
    public RegistrationService() {
    }
    
    //Get one registration
    public Registration getById(Integer id) {
        return registrationRepository.findById(id).get();
    }
    
    //Get all registration
    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }
    
    //Create new registration
    public Registration create(Registration registration) {
        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        registration.setDate(new Timestamp(date.getTime()));
        registration.setStatusRegistration(statusRegistrationRepository.findById(1).get());
        Registration r = registrationRepository.save(registration);
        r.setEmployee(employeeRepository.findById(r.getEmployee().getId()).get());
        r.setEvent(eventRepository.findById(r.getEvent().getId()).get());
        return r;
    }
    
    //Update status registration
    public Registration updateStatus(Integer id, StatusRegistration status) {
        Registration registration = registrationRepository.findById(id).get();
        registration.setStatusRegistration(status);
        return registrationRepository.save(registration);
    }
}
