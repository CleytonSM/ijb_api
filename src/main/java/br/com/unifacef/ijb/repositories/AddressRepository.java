package br.com.unifacef.ijb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.ijb.models.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

    
}
