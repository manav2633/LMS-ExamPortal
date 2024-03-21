package com.exam.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Emailconfig {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String email, String subject, String message) {
        // send email

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("devarshjoshi7@gmail.com");
        mailMessage.setTo();
        mailMessage.setSubject(subject);

        javaMailSender.send(mailMessage);
        System.out.println("Mail Sent...");

    }

}
