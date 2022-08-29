package co.develhope.email1.controllers;

import co.develhope.email1.email.EmailService;
import co.develhope.email1.entities.NotificationDTO;
import co.develhope.email1.entities.Student;
import co.develhope.email1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class NotificationController {

    @Autowired
    StudentService studentService;
    @Autowired
    EmailService emailService;

    @PostMapping("/notification")
    public ResponseEntity sendMail(@RequestBody NotificationDTO notify ){
        try{
            Student studentNotify = studentService.getStudentById(notify.getContactId());
            if(studentNotify == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("WARN :: studentNotify is null");
            emailService.sendTo(studentNotify.getEmail(), notify.getTitle(), notify.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("i criceti si stanno riposando");
        }
    }
}
