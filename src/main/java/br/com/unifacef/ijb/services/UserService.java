package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    protected User save(User user) {
        return repository.save(user);
    }

    public User createUser(UserCreateDTO user) {

    }
}
