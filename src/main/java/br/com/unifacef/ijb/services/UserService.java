package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.helpers.UserHelperConverter;
import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.unifacef.ijb.helpers.OptionalHelper.verifyEntityAlreadyExists;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    protected User save(User user) {
        return repository.save(user);
    }

    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        OptionalHelper.verifyEntityAlreadyExists(repository.findByEmail(userCreateDTO.getEmail()));

        userCreateDTO.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        User newUser = UserHelperConverter.convertUserCreateDTOToUser(userCreateDTO);

        return UserHelperConverter.convertUserToUserDTO(save(newUser));
    }
}
