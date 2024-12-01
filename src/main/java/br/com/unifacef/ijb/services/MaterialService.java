package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.MaterialMapper;
import br.com.unifacef.ijb.models.dtos.MaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialDTO;
import br.com.unifacef.ijb.models.dtos.MaterialUpdateDTO;
import br.com.unifacef.ijb.models.entities.Material;
import br.com.unifacef.ijb.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void createMaterial(MaterialCreateDTO materialCreate) {
        Material material = new Material(materialCreate.getName(), materialCreate.getQuantity(),
                materialCreate.getDescription(), materialCreate.getPrice(), materialCreate.getOrigin(),
                LocalDateTime.now());

        save(material);
    }

    public List<MaterialDTO> findAllMaterials() {
        List<Material> materials = repository.findAll();

        if (materials.isEmpty()) {
            return new ArrayList<>();
        }

        return MaterialMapper.convertListOfMaterialIntoListOfMaterialDTO(materials);
    }

    public void deleteById(Integer id) {
        repository.delete(getById(id));
    }

    public void updateMaterial(Integer id, MaterialUpdateDTO materialUpdate) {
        Material material = getById(id);

        material.setName(materialUpdate.getName());
        material.setQuantity(materialUpdate.getQuantity());
        material.setDescription(materialUpdate.getDescription());
        material.setPrice(materialUpdate.getPrice());
        material.setOrigin(materialUpdate.getOrigin());
        material.setUpdatedAt(LocalDateTime.now());

        save(material);
    }
}
