package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.PurchasedMaterialMapper;
import br.com.unifacef.ijb.models.dtos.PurchasedMaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.PurchasedMaterialDTO;
import br.com.unifacef.ijb.models.entities.PurchasedMaterial;
import br.com.unifacef.ijb.repositories.PurchasedMaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasedMaterialService {
    @Autowired
    private PurchasedMaterialRepository repository;

    public PurchasedMaterial save(PurchasedMaterial purchasedMaterial) {
        return repository.save(purchasedMaterial);
    }

    public PurchasedMaterial getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public PurchasedMaterialDTO createPurchasedMaterial(PurchasedMaterialCreateDTO purchasedMaterialCreate) {
        PurchasedMaterial purchasedMaterial = PurchasedMaterialMapper
                .convertPurchasedMaterialCreateDTOIntoPurchasedMaterial(purchasedMaterialCreate);

        return PurchasedMaterialMapper.convertPurchasedMaterialIntoPurchasedMaterialDTO(save(purchasedMaterial));
    }

    public List<PurchasedMaterialDTO> getAllPurchasedMaterials() {
        return PurchasedMaterialMapper.convertListOfPurchasedMaterialIntoListOfPurchasedMaterialDTO(repository.findAll());
    }

    public List<PurchasedMaterialDTO> getAllPurchasedMaterialsByFilter(String name) {
        List<PurchasedMaterial> purchasedMaterials = repository.findAllByMaterialName(name);
        if (!purchasedMaterials.isEmpty()) {
            return PurchasedMaterialMapper.convertListOfPurchasedMaterialIntoListOfPurchasedMaterialDTO(purchasedMaterials);
        }

        throw new EntityNotFoundException("There aren't purchased materials with this name");
    }

    @Transactional
    public PurchasedMaterialDTO updatePurchasedMaterial(PurchasedMaterialDTO purchasedMaterialUpdate) {
        PurchasedMaterial purchasedMaterial = getById(purchasedMaterialUpdate.getId());
        updateRetrievedEntity(purchasedMaterialUpdate, purchasedMaterial);

        return PurchasedMaterialMapper.convertPurchasedMaterialIntoPurchasedMaterialDTO(save(purchasedMaterial));
    }

    @Transactional
    public void deleteOutletProduct(Integer id) {
        PurchasedMaterial purchasedMaterial = getById(id);
        repository.delete(purchasedMaterial);
    }

    private void updateRetrievedEntity(PurchasedMaterialDTO purchasedMaterialUpdate, PurchasedMaterial purchasedMaterial) {
        PurchasedMaterialMapper.updatePurchasedMaterial(purchasedMaterialUpdate, purchasedMaterial);
    }


}
