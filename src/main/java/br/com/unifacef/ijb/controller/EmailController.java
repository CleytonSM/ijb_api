package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ijb/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    public static class EmailRequest {
        private String to;
        private String subject;
        private String body;

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }


    @PostMapping("/send-email")
    public ResponseEntity<String> enviarEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.enviarEmail(
                    emailRequest.getTo(),
                    emailRequest.getSubject(),
                    emailRequest.getBody()
            );
            return ResponseEntity.ok("Email enviado com sucesso!");
        } catch (MailException e) {
            return ResponseEntity.status(500).body("Erro ao enviar o e-mail: " + e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}