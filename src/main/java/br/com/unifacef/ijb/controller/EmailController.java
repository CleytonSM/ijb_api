package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/enviar-email")
    public String enviarEmail() {
        emailService.enviarEmail(
                "matheusspasti@gmail.com",
                "assunto teste",
                "teste"
        );
        return "Email enviado com sucesso!";
}
}