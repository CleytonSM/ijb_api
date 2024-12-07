package br.com.unifacef.ijb.repositories;

import br.com.unifacef.ijb.models.entities.OutletProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.ijb.models.entities.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
    List<Address> findAllByAddressCep(String cep);
    
}
