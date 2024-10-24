package br.com.unifacef.ijb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.ijb.models.entities.AddressUser;
import br.com.unifacef.ijb.models.entities.User;

public interface AddressUserRepository extends JpaRepository<AddressUser, User>{
    
}
