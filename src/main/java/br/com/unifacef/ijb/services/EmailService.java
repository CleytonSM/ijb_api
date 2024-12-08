package br.com.unifacef.ijb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(String destinatario, String assunto, String corpo) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(destinatario);
        email.setSubject(assunto);
        email.setText(corpo);
        email.setFrom("noreply.institutojoaodebarro@gmail.com");
        mailSender.send(email);
    }
}