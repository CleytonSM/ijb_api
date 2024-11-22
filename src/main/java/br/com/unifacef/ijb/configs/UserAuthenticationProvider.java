package br.com.unifacef.ijb.configs;

import br.com.unifacef.ijb.exceptions.WrongCredentialsException;
import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.models.entities.Authority;
import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.models.entities.UserInfo;
import br.com.unifacef.ijb.repositories.UserInfoRepository;
import br.com.unifacef.ijb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthenticationProvider {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserInfo userInfo = OptionalHelper.getOptionalEntity(userInfoRepository.findByUserEmailOrCPF(email));

        User user = userInfo.getUser();
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new WrongCredentialsException("Wrong credentials");
        }

        return new UsernamePasswordAuthenticationToken(userInfo, password, grantedAuthorities(userInfo.getAuthority()));
    }

    public List<GrantedAuthority> grantedAuthorities(Authority authority) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole().toString()));

        return grantedAuthorities;
    }
}
