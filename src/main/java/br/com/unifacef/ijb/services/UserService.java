package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.UserMapper;
import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    protected User save(User user) {
        return repository.save(user);
    }

    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        OptionalHelper.verifyEntityAlreadyExists(repository.findByEmail(userCreateDTO.getEmail()));

        userCreateDTO.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));

        User newUser = UserMapper.convertUserCreateDTOToUser(userCreateDTO);

        return UserMapper.convertUserToUserDTO(save(newUser));
    }

    public UserDTO getUserByEmail(String email) {
        User user = OptionalHelper.getOptionalEntity(repository.findByEmail(email));

        return UserMapper.convertUserIntoUserDTO(user);
    }
}
