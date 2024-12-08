package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.configs.UserAuthenticationProvider;
import br.com.unifacef.ijb.models.dtos.BeneficiaryRegisterDTO;
import br.com.unifacef.ijb.models.dtos.LoginDTO;
import br.com.unifacef.ijb.models.dtos.LoginResponseDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;
import br.com.unifacef.ijb.repositories.UserRepository;
import br.com.unifacef.ijb.securities.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private BeneficiaryService beneficiaryService;

    public LoginResponseDTO login(LoginDTO login) {
        Authentication authentication = setUpAuthenticationByLoginDTO(login);

        String token = jwtProvider.createToken(authentication);
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();

        return new LoginResponseDTO(token, userInfo.getName(), userInfo.getAuthority().getRole());
    }

    public void volunteerRegister(VolunteerRegisterDTO volunteerRegister) {
        volunteerService.createVolunteer(volunteerRegister, "VOLUNTARIO");
    }

    public void supporterRegister(VolunteerRegisterDTO volunteerRegister) {
        volunteerService.createVolunteer(volunteerRegister, "APOIADOR");
    }

    public void beneficiaryRegister(BeneficiaryRegisterDTO beneficiaryRegister) {
        beneficiaryService.registerBeneficiary(beneficiaryRegister);
    }

    private Authentication setUpAuthenticationByLoginDTO(LoginDTO login) {
        return userAuthenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmailOrCpf(), login.getPassword(), null));
    }
}
