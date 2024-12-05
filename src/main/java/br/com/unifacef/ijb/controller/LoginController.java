package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.BeneficiaryRegisterDTO;
import br.com.unifacef.ijb.models.dtos.LoginDTO;
import br.com.unifacef.ijb.models.dtos.LoginResponseDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;
import br.com.unifacef.ijb.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/ijb")
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping("/register/volunteer")
    public ResponseEntity<Void> volunteerRegister(@RequestBody VolunteerRegisterDTO volunteerRegister) {
        service.volunteerRegister(volunteerRegister);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register/supporter")
    public ResponseEntity<Void> supporterRegister(@RequestBody VolunteerRegisterDTO volunteerRegister) {
        service.supporterRegister(volunteerRegister);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register/volunteer_supporter")
    public ResponseEntity<Void> volunteerSupporterRegister(@RequestBody VolunteerRegisterDTO volunteerRegister) {
        service.volunteerSupporterRegister(volunteerRegister);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/register/beneficiary")
    public ResponseEntity<Void> beneficiaryRegister(@RequestBody BeneficiaryRegisterDTO beneficiaryRegister) {
        service.beneficiaryRegister(beneficiaryRegister);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO login) {
        return new ResponseEntity<>(service.login(login), HttpStatus.OK);
    }
}
