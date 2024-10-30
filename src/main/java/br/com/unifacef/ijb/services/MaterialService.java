package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.MaterialMapper;
import br.com.unifacef.ijb.mappers.OutletProductMapper;
import br.com.unifacef.ijb.models.dtos.MaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import br.com.unifacef.ijb.models.entities.Material;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.repositories.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository repository;

    public Material save(Material material){
        return repository.save(material);
    }

    public Material getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public MaterialDTO createMaterial(MaterialCreateDTO materialCreate) {
        Material material = MaterialMapper
                .convertMaterialCreateDTOIntoMaterial(materialCreate);

        return MaterialMapper.convertMaterialIntoMaterialDTO(save(material));
    }

    public List<MaterialDTO> getAllMaterials() {
        return MaterialMapper.convertListOfMaterialIntoListOfMaterialDTO(repository.findAll());
    }

    public List<MaterialDTO> getAllMaterialsByFilter(Integer id) {
        List<Material> materials = repository.findAllByMaterialId(id);
        if (!materials.isEmpty()) {
            return MaterialMapper.convertListOfMaterialIntoListOfMaterialDTO(materials);
        }

        throw new EntityNotFoundException("There aren't materials with this ID");
    }

    @Transactional
    public MaterialDTO updateMaterial(MaterialDTO materialUpdate) {
        Material material = getById(materialUpdate.getId());
        updateRetrievedEntity(materialUpdate, material);

        return MaterialMapper.convertMaterialIntoMaterialDTO(save(material));
    }

    private void updateRetrievedEntity(MaterialDTO materialUpdate, Material material) {
        MaterialMapper.updateMaterial(materialUpdate, material);
    }

    @Transactional
    public void deleteMaterial(Integer id) {
        Material material = OptionalHelper.getOptionalEntity(repository.findById(id));
        repository.delete(material);
    }

}
