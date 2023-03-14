package com.example.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender; // lấy bean từ class để sử dụng các method

    public void sendMail(String email , String subject , String content){
        SimpleMailMessage message = new SimpleMailMessage(); // tạo ra đối tưởng Mail đơn giản
        message.setTo(email);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }

}
