package com.hateyahighschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by A.A.MAMUN on 7/18/2019.
 */
@Controller
public class ContactController {


    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/contact")
    private String initContactPage()
    {
        return "contact";
    }


    private void sendEmail() {

        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            // msg.setTo("to_1@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");

            msg.setFrom("babushikder340@gmail.com");
            msg.setText("aalmamun295@gmail.com");
            msg.setSubject("Testing from Spring Boot");
            msg.setText("Hello World \n Spring Boot Email");

            javaMailSender.send(msg);

            System.out.println("Successfully sent....................");
        }catch (Exception e){
            System.out.println(e+"\n................");
        }

    }
}
