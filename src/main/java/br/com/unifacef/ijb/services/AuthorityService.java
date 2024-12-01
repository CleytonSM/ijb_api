package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.mappers.AuthorityMapper;
import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.entities.Authority;
import br.com.unifacef.ijb.models.enums.Role;
import br.com.unifacef.ijb.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository repository;

    public AuthorityDTO findAuthorityRole(Role role) {
        return AuthorityMapper.convertAuthorityIntoAuthorityDTO(repository.findByRole(role));
    }
}
