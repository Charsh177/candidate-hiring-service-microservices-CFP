package com.lms.candidate.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        System.out.println(toEmail + " " + subject + " " + body);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("harshchougule177@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        System.out.println(simpleMailMessage);
        javaMailSender.send(simpleMailMessage);
        System.out.println("Mail Sent Successfully...");
    }
}