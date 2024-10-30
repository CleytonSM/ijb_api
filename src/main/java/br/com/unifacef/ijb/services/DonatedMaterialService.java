package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.DonatedMaterialMapper;
import br.com.unifacef.ijb.mappers.OutletProductMapper;
import br.com.unifacef.ijb.models.dtos.DonatedMaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.DonatedMaterialDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.repositories.DonatedMaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DonatedMaterialService {
    @Autowired
    private DonatedMaterialRepository repository;

    public DonatedMaterial save(DonatedMaterial donatedMaterial){ return repository.save(donatedMaterial);}

    @Transactional
    public DonatedMaterialDTO createDonateMaterial(DonatedMaterialCreateDTO donatedMaterialCreate){
        DonatedMaterial donatedMaterial = DonatedMaterialMapper
                .convertDonatedMaterialCreateDTOIntoDonatedMaterial(donatedMaterialCreate);
        donatedMaterial = save(donatedMaterial);

        return DonatedMaterialMapper.convertDonatedMaterialtIntoDonatedMaterialDTO(donatedMaterial);
    }

    public List<DonatedMaterialDTO> getAllDonatedMaterials() {
        return DonatedMaterialMapper.convertListOfDonatedMaterialIntoListOfDonatedMaterialDTO(repository.findAll());
    }

    public List<DonatedMaterialDTO> getAllDonatedMaterialsByFilter(String name) {
        List<DonatedMaterial> donatedMaterials = repository.findAllByDonatedMaterialName(name);
        if (!donatedMaterials.isEmpty()) {
            return DonatedMaterialMapper.convertListOfDonatedMaterialIntoListOfDonatedMaterialDTO(donatedMaterials);
        }

        throw new EntityNotFoundException("There aren't donated materials with this name");
    }

    @Transactional
    public DonatedMaterialDTO updateDonatedMaterial(DonatedMaterialDTO donatedMaterialUpdate){
        DonatedMaterial donatedMaterial = OptionalHelper.getOptionalEntity(repository
                .findById(donatedMaterialUpdate.getId()));
        DonatedMaterialMapper.updateDonatedMaterial(donatedMaterialUpdate, donatedMaterial);

        donatedMaterial = save(donatedMaterial);
        return DonatedMaterialMapper.convertDonatedMaterialtIntoDonatedMaterialDTO(donatedMaterial);
    }

    @Transactional
    public void deleteDonatedMaterial(Integer id) {
        DonatedMaterial donatedMaterial = OptionalHelper.getOptionalEntity(repository.findById(id));
        repository.delete(donatedMaterial);
    }



}
