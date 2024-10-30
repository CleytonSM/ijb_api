package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.MaterialInUseMapper;
import br.com.unifacef.ijb.mappers.OutletProductMapper;
import br.com.unifacef.ijb.models.dtos.MaterialInUseCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialInUseDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.MaterialInUse;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.repositories.MaterialInUseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialInUseService {
    @Autowired
    private MaterialInUseRepository repository;

    public MaterialInUse save(MaterialInUse materialInUse) {
        return repository.save(materialInUse);
    }

    public MaterialInUse getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public MaterialInUseDTO createMaterialInUse(MaterialInUseCreateDTO materialInUseCreate) {
        MaterialInUse materialInUse = MaterialInUseMapper
                .convertMaterialInUseCreateDTOIntoMaterialInUse(materialInUseCreate);

        return MaterialInUseMapper.convertMaterialInUseIntoMaterialInUseDTO(save(materialInUse));
    }

    public List<MaterialInUseDTO> getAllMaterialsInUse() {
        return MaterialInUseMapper.convertListOfMaterialInUseIntoListOfMaterialInUseDTO(repository.findAll());
    }

    public List<MaterialInUseDTO> getAllMaterialInUseByFilter(Integer id) {
        List<MaterialInUse> materialsInUse = repository.findAllByMaterialInUseId(id);
        if (!materialsInUse.isEmpty()) {
            return MaterialInUseMapper.convertListOfMaterialInUseIntoListOfMaterialInUseDTO(materialsInUse);
        }

        throw new EntityNotFoundException("There aren't materials in use with this id");
    }

    @Transactional
    public MaterialInUseDTO updateMaterialInUse(MaterialInUseDTO materialInUseUpdate) {
        MaterialInUse materialInUse = getById(materialInUseUpdate.getId());
        updateRetrievedEntity(materialInUseUpdate, materialInUse);

        return MaterialInUseMapper.convertMaterialInUseIntoMaterialInUseDTO(save(materialInUse));
    }

    @Transactional
    public void deleteMaterialInUse(Integer id) {
        MaterialInUse materialInUse = getById(id);
        repository.delete(materialInUse);
    }

    private void updateRetrievedEntity(MaterialInUseDTO materialInUseUpdate, MaterialInUse materialInUse) {
        MaterialInUseMapper.updateMaterialInUse(materialInUseUpdate, materialInUse);
    }

}
