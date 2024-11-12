package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.ExchangedMaterialMapper;
import br.com.unifacef.ijb.mappers.OutletProductMapper;
import br.com.unifacef.ijb.mappers.PurchasedMaterialMapper;
import br.com.unifacef.ijb.models.dtos.*;
import br.com.unifacef.ijb.models.entities.ExchangedMaterial;
import br.com.unifacef.ijb.models.entities.Material;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.models.entities.PurchasedMaterial;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.repositories.ExchangedMaterialRepository;
import br.com.unifacef.ijb.repositories.OutletProductRepository;
import br.com.unifacef.ijb.repositories.PurchasedMaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangedMaterialService {
    @Autowired
    private ExchangedMaterialRepository repository;

    public ExchangedMaterial save(ExchangedMaterial exchangedMaterial) {
        return repository.save(exchangedMaterial);
    }

    public ExchangedMaterial getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public ExchangedMaterialDTO createExchangedMaterial(ExchangedMaterialCreateDTO exchangedMaterialCreate) {
        ExchangedMaterial exchangedMaterial = ExchangedMaterialMapper.
                convertExchangedMaterialCreateDTOIntoExchangedMaterial(exchangedMaterialCreate);


        return ExchangedMaterialMapper.convertExchangedMaterialIntoExchangedMaterialDTO(save(exchangedMaterial));
    }

    public List<ExchangedMaterialDTO> getAllExchangedMaterials() {
        return ExchangedMaterialMapper.convertListOfExchangedMaterialIntoListOfExchangedMaterialDTO(repository.findAll());
    }

    public List<ExchangedMaterialDTO> getAllExchangedMaterialsByFilter(Material material ) {
        List<ExchangedMaterial> exchangedMaterials = repository.findAllByMaterialId(material);
        if (!exchangedMaterials.isEmpty()) {
            return ExchangedMaterialMapper.convertListOfExchangedMaterialIntoListOfExchangedMaterialDTO(exchangedMaterials);
        }

        throw new EntityNotFoundException("There aren't materials with this id");
    }

    @Transactional
    public ExchangedMaterialDTO updateExchangedMaterial(ExchangedMaterialDTO exchangedMaterialUpdate) {

        Integer materialId = exchangedMaterialUpdate.getMaterial().getId();
        ExchangedMaterial exchangedMaterial = getExchangedMaterialById(materialId);
        updateRetrievedEntity(exchangedMaterialUpdate, exchangedMaterial);
        return ExchangedMaterialMapper.convertExchangedMaterialIntoExchangedMaterialDTO(saveExchangedMaterial(exchangedMaterial));
    }

    @Transactional
    public void deleteExchangedMaterial(Integer id) {

        ExchangedMaterial exchangedMaterial = getExchangedMaterialById(id);
        repository.delete(exchangedMaterial);
    }

    private ExchangedMaterial getExchangedMaterialById(Integer materialId) {
        return repository.findById(materialId)
                .orElseThrow(() -> new EntityNotFoundException("Material not found with ID: " + materialId));
    }

    private void updateRetrievedEntity(ExchangedMaterialDTO dto, ExchangedMaterial entity) {
        ExchangedMaterialMapper.updateExchangedMaterial(dto, entity);
    }

    private ExchangedMaterial saveExchangedMaterial(ExchangedMaterial exchangedMaterial) {
        return repository.save(exchangedMaterial);
    }


}
