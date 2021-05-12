/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import mii.co.id.servertrainingmanagement.dto.ApplicantDTO;
import mii.co.id.servertrainingmanagement.dto.EventRequestDTO;
import mii.co.id.servertrainingmanagement.dto.PresenceDTO;
import mii.co.id.servertrainingmanagement.entities.Category;
import mii.co.id.servertrainingmanagement.entities.Event;
import mii.co.id.servertrainingmanagement.entities.Presence;
import mii.co.id.servertrainingmanagement.entities.Registration;
import mii.co.id.servertrainingmanagement.entities.Schedule;
import mii.co.id.servertrainingmanagement.repositories.CategoryRepository;
import mii.co.id.servertrainingmanagement.repositories.EventRepository;
import mii.co.id.servertrainingmanagement.repositories.PresenceRepository;
import mii.co.id.servertrainingmanagement.repositories.RegistrationRepository;
import mii.co.id.servertrainingmanagement.repositories.ScheduleRepository;
import mii.co.id.servertrainingmanagement.repositories.StatusEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    PresenceRepository presenceRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    StatusEventRepository statusEventRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    public EventService() {
    }

    //Get one event
    public Event getById(Integer id) {
        return eventRepository.findById(id).get();
    }

    //Get all event
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    //Get all event (status open)
    public List<Event> getAllOpen() {
        return statusEventRepository.findById(1).get().getEventList();
    }

    //Get all event (status not open)
    public List<Event> getAllNotOpen() {
        List<Event> events = statusEventRepository.findById(2).get().getEventList();
        events.addAll(statusEventRepository.findById(3).get().getEventList());
        events.addAll(statusEventRepository.findById(4).get().getEventList());
        return events;
    }

    //Create new event
//    public Event create(Event event) {
//        if(!categoryRepository.existsById(event.getCategory().getId())) {
//            event.setCategory(categoryRepository.save(event.getCategory()));
//        }
//        Schedule schedule = event.getSchedule();
//        schedule.setScheduleId(event.getId());
//        schedule.setEvent(event);
//        scheduleRepository.save(schedule);
//        event.getSchedule().setScheduleId(event.getId());
//        event.setStatusEvent(statusEventRepository.findById(1).get());
//        event.setApplicant(0);
//        return eventRepository.save(event);
//    }
    //Update event
    public Event update(Integer id, Event event) {
        event.setId(id);
        return eventRepository.save(event);
    }

    //Delete event (soft delete -> status berubah ke cancelled)
    public Event softDelete(Integer id) {
        Event event = eventRepository.findById(id).get();
        event.setStatusEvent(statusEventRepository.findById(4).get());
        return eventRepository.save(event);
    }

    public Event create(EventRequestDTO req) throws ParseException {
        Event event = new Event(
                req.getId(),
                req.getName(),
                req.getDescription(),
                req.getTrainer(),
                req.getQuota(),
                0,
                req.getRequirement(),
                req.getPoint(),
                new Category(req.getCategoryId()),
                new Schedule(
                        req.getId(),
                        new SimpleDateFormat("yyyy-MM-dd").parse(req.getDate()),
                        new SimpleDateFormat("HH:mm").parse(req.getStartTime()),
                        new SimpleDateFormat("HH:mm").parse(req.getEndTime()),
                        req.getLocation(),
                        req.getIsOnline()),
                statusEventRepository.findById(1).get());
        return eventRepository.save(event);
    }

    ;
    
//    public List<Registration> getSubmission(Integer id) {
//        List<Registration> submissions = eventRepository.findById(id).get().getRegistrationList();
//        return submissions;
        
    public List<ApplicantDTO> getApplicants(Integer eventId) {
        List<Registration> registrations = eventRepository.findById(eventId).get().getRegistrationList();
        List<ApplicantDTO> applicants = new ArrayList<>();
        for (Registration r : registrations) {
            if(r.getStatusRegistration().getId()==1){
            applicants.add(new ApplicantDTO(
                    r.getId(),
                    r.getEmployee().getId(),
                    r.getEmployee().getName(),
                    r.getEmployee().getDepartment().getName(),
                    r.getEmployee().getJob().getName(), r.getStatusRegistration().getName()));
        }
        }
        return applicants;
    }

    public List<PresenceDTO> getPresences(Integer eventId) {
        List<Registration> registrations = eventRepository.findById(eventId).get().getRegistrationList();
        List<PresenceDTO> presences = new ArrayList<>();
        for (Registration p : registrations) {
            if (p.getStatusRegistration().getId() == 2) {
                presences.add(new PresenceDTO(
                        p.getId(),
                        p.getEmployee().getName(),
                        p.getEmployee().getDepartment().getName(),
                        p.getPresence().getStatusPresence()));
            }
        }
        System.out.println(registrationRepository.findAll());
        System.out.println(presences);
        return presences;
    }
}
