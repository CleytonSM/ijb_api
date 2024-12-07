package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.AddressMapper;
import br.com.unifacef.ijb.mappers.ConstructionMapper;
import br.com.unifacef.ijb.models.dtos.*;
import br.com.unifacef.ijb.models.entities.Address;
import br.com.unifacef.ijb.models.entities.Construction;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.repositories.AddressRepository;
import br.com.unifacef.ijb.repositories.ConstructionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public Address save(Address address) {
        return repository.save(address);
    }

    public Address getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    public Address createAddress(AddressCreateDTO addressCreate) {
        Address address = new Address(
                addressCreate.getCep(), addressCreate.getStreet(),
                addressCreate.getNumber(), addressCreate.getNeighborhood(), addressCreate.getComplement());
        return save(address);
    }


    public List<AddressDTO> findByFilter() {
        List<Address> addresses = repository.findAll();

        if(addresses.isEmpty()){
            return new ArrayList<>();
        }

        return AddressMapper.convertListOfAddressIntoListOfAddressDTO(addresses);
    }

    @Transactional
    public void deleteAddress(Integer id) {
        repository.delete(getById(id));
    }

    public Address updateAddress(Integer id, AddressUpdateDTO addressUpdate) {
        Address address = getById(id);

        address.setCep(addressUpdate.getCep());
        address.setStreet(addressUpdate.getStreet());
        address.setNumber(addressUpdate.getNumber());
        address.setNeighborhood(addressUpdate.getNeighborhood());
        address.setComplement(addressUpdate.getComplement());
        address.setUpdatedAt(LocalDateTime.now());

        return save(address);
    }

}
