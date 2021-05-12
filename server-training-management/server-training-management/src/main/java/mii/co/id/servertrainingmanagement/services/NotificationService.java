/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;


import java.util.Locale;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import mii.co.id.servertrainingmanagement.entities.Employee;
import mii.co.id.servertrainingmanagement.entities.Event;
import mii.co.id.servertrainingmanagement.entities.Registration;
import mii.co.id.servertrainingmanagement.repositories.AccountRepository;
import mii.co.id.servertrainingmanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author ACER
 */
@Service
public class NotificationService {
    
    @Autowired
    JavaMailSender javaMailSender;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    RegistrationService registrationService;
    
    @Autowired
    TemplateEngine templateEngine;
    
    @Value("${mail.server.username}")
    String sender;

    public NotificationService() {
    }
    
    public void sendEmail(Integer userId, Registration registration) throws MessagingException {
        Employee employee = employeeRepository.findById(userId).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom(sender);
        
        helper.setTo(accountRepository.findById(userId).get().getEmail());
        
        Event event = registration.getEvent();
        
        helper.setSubject(String.format("[Training IMB] %s", event.getName()));
        
        message.setText(String.format(
                "Hi %s,Thank you for your interest to apply in our training event:"
                        + "\nTittle : %s"
                        + "Trainer : %s"
                        + "Category : %s"
//                        + "%nThis event will be held on %s", 
                        + "You will be able to attend the event after we approve your request and we will further notify you via email."
                        + "Hope to see you there!"
                        + "Best Regards,"
                        + "IMB Training Management Team",
                employee.getName(),
                event.getName(),
                event.getTrainer(),
                event.getCategory().getName()
//                event.getSchedule().getDate(),
//                event.getSchedule().getStartTime(),
//                event.getSchedule().getEndTime()
                ),
                "UTF-8", "html");
        
        javaMailSender.send(message);
    }
    
    public void sendEmailHTML(Integer userId, Registration registration, Locale locale, String htmlFile) throws MessagingException {
        Employee employee = employeeRepository.findById(userId).get();
        Event event = registration.getEvent();
        
        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("userName", employee.getName());
        ctx.setVariable("eventName", event.getName());
        ctx.setVariable("trainer", event.getTrainer());
        ctx.setVariable("category", event.getCategory().getName());
        ctx.setVariable("date", event.getSchedule().getDate());
        ctx.setVariable("startTime", event.getSchedule().getStartTime());
        ctx.setVariable("endTime", event.getSchedule().getEndTime());
        ctx.setVariable("loc", event.getSchedule().getLocation());
    
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setFrom(sender);
        
        helper.setTo(accountRepository.findById(userId).get().getEmail());
        
        helper.setSubject(String.format("[Training IMB] %s", event.getName()));
        
        // Create the HTML body using Thymeleaf
        final String htmlContent = templateEngine.process(htmlFile, ctx);
        helper.setText(htmlContent, true); // true = isHtml
        
        javaMailSender.send(message);
    }
}
