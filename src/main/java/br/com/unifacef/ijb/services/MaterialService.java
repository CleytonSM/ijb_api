package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.MaterialMapper;
import br.com.unifacef.ijb.models.dtos.DonatedMaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialDTO;
import br.com.unifacef.ijb.models.dtos.MaterialFilterResponseDTO;
import br.com.unifacef.ijb.models.dtos.MaterialUpdateDTO;
import br.com.unifacef.ijb.models.dtos.PurchasedMaterialCreateDTO;
import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import br.com.unifacef.ijb.models.entities.Material;
import br.com.unifacef.ijb.models.entities.PurchasedMaterial;
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
    @Autowired
    private DonatedMaterialService donatedMaterialService;
    @Autowired
    private PurchasedMaterialService purchasedMaterialService;

    public Material save(Material material){
        return repository.save(material);
    }

    public Material getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public MaterialDTO createMaterial(MaterialCreateDTO materialCreate) {
        Material material = new Material();

        assignMaterialType(materialCreate, material);

        return MaterialMapper.convertMaterialIntoMaterialDTO(save(material));
    }

    public List<MaterialDTO> getAllMaterials() {
        return MaterialMapper.convertListOfMaterialIntoListOfMaterialDTO(repository.findAll());
    }

    public List<MaterialDTO> getAllMaterialsByFilter(Integer id) {
        List<Material> materials = repository.findAllById(id);
        if (!materials.isEmpty()) {
            return MaterialMapper.convertListOfMaterialIntoListOfMaterialDTO(materials);
        }

        throw new EntityNotFoundException("There aren't materials with this ID");
    }

    @Transactional
    public void updateMaterial(MaterialUpdateDTO materialUpdate) {
        if(materialUpdate.getIsDonated()) {
            Material material = OptionalHelper.getOptionalEntity(repository
                    .findByDonatedMaterialId(materialUpdate.getId()));

            material = MaterialMapper.updateMaterial(materialUpdate, material);

            save(material);
            return;
        }
        Material material = OptionalHelper.getOptionalEntity(repository
                .findByPurchasedMaterialId(materialUpdate.getId()));

        material = MaterialMapper.updateMaterial(materialUpdate, material);

        save(material);
    }

    public MaterialFilterResponseDTO findByFilter(String search) {
        MaterialFilterResponseDTO materialFilterResponse = new MaterialFilterResponseDTO();
        materialFilterResponse.setDonatedMaterials(donatedMaterialService.findByFilter(search));
        materialFilterResponse.setPurchasedMaterials(purchasedMaterialService.findByFilter(search));

        return materialFilterResponse;
    }

    @Transactional
    public void deleteMaterial(Integer id, Boolean isDonation) {
       if(isDonation) {
           DonatedMaterial donatedMaterial = donatedMaterialService.getById(id);
           repository.deleteByDonatedMaterial(donatedMaterial);

           donatedMaterialService.deleteDonatedMaterial(id);

           return;
       }

       PurchasedMaterial purchasedMaterial = purchasedMaterialService.getById(id);
       repository.deleteByPurchasedMaterial(purchasedMaterial);

       purchasedMaterialService.deletePurchasedMaterial(id);
    }

    private void assignMaterialType(MaterialCreateDTO materialCreate, Material material) {
        if(materialCreate.getIsDonated()) {
            DonatedMaterialCreateDTO donatedMaterialCreateDTO = new DonatedMaterialCreateDTO(
                    materialCreate.getMaterialName(), materialCreate.getQuantity(), materialCreate.getDescription());

            DonatedMaterial donatedMaterial = donatedMaterialService.createDonatedMaterial(donatedMaterialCreateDTO);

            material.setDonatedMaterial(donatedMaterial);

            return;
        }
        PurchasedMaterialCreateDTO purchasedMaterialCreateDTO = new PurchasedMaterialCreateDTO(
                materialCreate.getMaterialName(), materialCreate.getQuantity(), materialCreate.getDescription());

        PurchasedMaterial purchasedMaterial = purchasedMaterialService.createPurchasedMaterial(purchasedMaterialCreateDTO);

        material.setPurchasedMaterial(purchasedMaterial);
    }
}
