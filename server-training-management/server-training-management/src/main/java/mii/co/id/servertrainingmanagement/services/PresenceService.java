/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.servertrainingmanagement.dto.PresenceDTO;
import mii.co.id.servertrainingmanagement.dto.StatusPresence;
import mii.co.id.servertrainingmanagement.entities.Presence;
import mii.co.id.servertrainingmanagement.entities.Registration;
import mii.co.id.servertrainingmanagement.repositories.PresenceRepository;
import mii.co.id.servertrainingmanagement.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class PresenceService {

    @Autowired
    PresenceRepository presenceRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    
    public List<Presence> getAll() {
        return presenceRepository.findAll();
    }
    
    public Presence getById(Integer id) {
        return presenceRepository.findById(id).get();
    }

    
    
//    Update status presence -> yes
    public Presence updateStatusYes(Integer id) {
        Presence presence = presenceRepository.findById(id).get();
        presence.setStatusPresence(StatusPresence.yes);
        return presenceRepository.save(presence);
    }
    
//    Update status presence -> no
    public Presence updateStatusNo(Integer id) {
        Presence presence = presenceRepository.findById(id).get();
        presence.setStatusPresence(StatusPresence.no);
        return presenceRepository.save(presence);
    }
}

