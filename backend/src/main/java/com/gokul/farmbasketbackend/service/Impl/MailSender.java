package com.gokul.farmbasketbackend.service.Impl;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSender {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender javaMailSender;

    public void send(String emailTo,String subject,String message){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}
