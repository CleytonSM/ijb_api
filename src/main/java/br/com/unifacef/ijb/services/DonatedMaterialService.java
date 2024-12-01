package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.DonatedMaterialMapper;
import br.com.unifacef.ijb.models.dtos.DonatedMaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.DonatedMaterialDTO;
import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import br.com.unifacef.ijb.repositories.DonatedMaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DonatedMaterialService {
    @Autowired
    private DonatedMaterialRepository repository;

    public DonatedMaterial save(DonatedMaterial donatedMaterial){ return repository.save(donatedMaterial);}

    @Transactional
    public DonatedMaterial createDonatedMaterial(DonatedMaterialCreateDTO donatedMaterialCreate){
        DonatedMaterial donatedMaterial = DonatedMaterialMapper
                .convertDonatedMaterialCreateDTOIntoDonatedMaterial(donatedMaterialCreate);

        return save(donatedMaterial);
    }

    public List<DonatedMaterialDTO> getAllDonatedMaterials() {
        return DonatedMaterialMapper.convertListOfDonatedMaterialIntoListOfDonatedMaterialDTO(repository.findAll());
    }

    public List<DonatedMaterialDTO> getAllDonatedMaterialsByFilter(String name) {
        List<DonatedMaterial> donatedMaterials = repository.findAllByMaterialName(name);
        if (!donatedMaterials.isEmpty()) {
            return DonatedMaterialMapper.convertListOfDonatedMaterialIntoListOfDonatedMaterialDTO(donatedMaterials);
        }

        throw new EntityNotFoundException("There aren't donated materials with this name");
    }

    @Transactional
    public DonatedMaterialDTO updateDonatedMaterial(DonatedMaterialDTO donatedMaterialUpdate){
        DonatedMaterial donatedMaterial = getById(donatedMaterialUpdate.getId());
        DonatedMaterialMapper.updateDonatedMaterial(donatedMaterialUpdate, donatedMaterial);

        donatedMaterial = save(donatedMaterial);
        return DonatedMaterialMapper.convertDonatedMaterialtIntoDonatedMaterialDTO(donatedMaterial);
    }

    @Transactional
    public void deleteDonatedMaterial(Integer id) {
        repository.delete(getById(id));
    }


    public List<DonatedMaterialDTO> findByFilter(String search) {
        List<DonatedMaterial> donatedMaterials = findPurchasedMaterialsBySearch(search);
        if (Optional.ofNullable(donatedMaterials).isPresent() && !donatedMaterials.isEmpty()) {
            return DonatedMaterialMapper.convertListOfDonatedMaterialIntoListOfDonatedMaterialDTO(donatedMaterials);
        }

        return null;
    }

    private List<DonatedMaterial> findPurchasedMaterialsBySearch(String search) {
        return repository.findAllBySearch(search);
    }

    public DonatedMaterial getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }
}
