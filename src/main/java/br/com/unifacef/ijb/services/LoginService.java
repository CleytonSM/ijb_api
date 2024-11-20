package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.configs.UserAuthenticationProvider;
import br.com.unifacef.ijb.models.dtos.LoginDTO;
import br.com.unifacef.ijb.models.dtos.LoginResponseDTO;
import br.com.unifacef.ijb.models.dtos.SupporterRegisterDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;
import br.com.unifacef.ijb.models.entities.UserInfo;
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

    public LoginResponseDTO login(LoginDTO login) {
        Authentication authentication = setUpAuthenticationByLoginDTO(login);

        String token = jwtProvider.createToken(authentication);

        return new LoginResponseDTO(token);
    }

    public void volunteerRegister(VolunteerRegisterDTO volunteerRegister) {
        volunteerService.createVolunteer(volunteerRegister);
    }

    public void supporterRegister(SupporterRegisterDTO supporterRegister) {

    }

    private Authentication setUpAuthenticationByLoginDTO(LoginDTO login) {
        return userAuthenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(login, login.getPassword(), null));
    }
}
