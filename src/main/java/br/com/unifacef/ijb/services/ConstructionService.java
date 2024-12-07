package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.ConstructionMapper;
import br.com.unifacef.ijb.models.dtos.AddressUpdateDTO;
import br.com.unifacef.ijb.models.dtos.ConstructionCreateDTO;
import br.com.unifacef.ijb.models.dtos.ConstructionDTO;
import br.com.unifacef.ijb.models.dtos.ConstructionUpdateDTO;
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
public class ConstructionService {
    @Autowired
    private ConstructionRepository repository;
    @Autowired
    private AddressService addressService;

    public Construction save(Construction construction) {
        return repository.save(construction);
    }

    public Construction getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    public void createConstruction(ConstructionCreateDTO constructionCreate) {
        Address address = addressService.createAddress(constructionCreate.getAddress());

        Construction construction = new Construction(address,
                constructionCreate.getDescription(), constructionCreate.getStartDate(),
                constructionCreate.getEndDate(), constructionCreate.getConstructionStatus(), constructionCreate.getEstimatedCost(),
                constructionCreate.getTotalCost());


        save(construction);
    }

    public List<ConstructionDTO> findByFilter() {
        List<Construction> constructions = repository.findAll();

        if(constructions.isEmpty()){
            return new ArrayList<>();
        }

        return ConstructionMapper.convertListOfConstructionIntoListOfConstructionDTO(constructions);
    }

    @Transactional
    public void deleteConstruction(Integer id) {
        repository.delete(getById(id));
    }

    public void updateConstruction(Integer id, ConstructionUpdateDTO constructionUpdate) {
        Construction construction = getById(id);

        Address updatedAddress = addressService.updateAddress(
                constructionUpdate.getAddress().getId(),
                new AddressUpdateDTO(
                        constructionUpdate.getAddress().getCep(),
                        constructionUpdate.getAddress().getStreet(),
                        constructionUpdate.getAddress().getNumber(),
                        constructionUpdate.getAddress().getNeighborhood(),
                        constructionUpdate.getAddress().getComplement()
                )
        );

        construction.setAddress(updatedAddress);
        construction.setDescription(constructionUpdate.getDescription());
        construction.setStartDate(constructionUpdate.getStartDate());
        construction.setEndDate(constructionUpdate.getEndDate());
        construction.setConstructionStatus(constructionUpdate.getConstructionStatus());
        construction.setEstimatedCost(constructionUpdate.getEstimatedCost());
        construction.setTotalCost(constructionUpdate.getTotalCost());
        construction.setUpdatedAt(LocalDateTime.now());

        save(construction);
    }
}
