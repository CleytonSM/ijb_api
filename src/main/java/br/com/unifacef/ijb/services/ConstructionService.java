package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.ConstructionMapper;
import br.com.unifacef.ijb.mappers.OutletProductMapper;
import br.com.unifacef.ijb.models.dtos.ConstructionCreateDTO;
import br.com.unifacef.ijb.models.dtos.ConstructionDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.Construction;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.repositories.ConstructionRepository;
import br.com.unifacef.ijb.repositories.OutletProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructionService {
    @Autowired
    private ConstructionRepository repository;

    public Construction save(Construction construction) {
        return repository.save(construction);
    }

    public Construction getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public ConstructionDTO createConstruction(ConstructionCreateDTO constructionCreate) {
        Construction construction = ConstructionMapper
                .convertConstructionCreateDTOIntoConstruction(constructionCreate);

        return ConstructionMapper.convertConstructionIntoConstructionDTO(save(construction));
    }

    public List<ConstructionDTO> getAllConstructions() {
        return ConstructionMapper.convertListOfConstructionIntoListOfConstructionDTO(repository.findAll());
    }

    public List<ConstructionDTO> getAllConstructionsByFilter(String description) {
        List<Construction> constructions = repository.findAllByConstructionDescription(description);


        if (!constructions.isEmpty()) {
            return ConstructionMapper.convertListOfConstructionIntoListOfConstructionDTO(constructions);
        }

        throw new EntityNotFoundException("There aren't Contrusctions with this description");
    }

    @Transactional
    public ConstructionDTO updateConstruction(ConstructionDTO constructionUpdate) {
        Construction construction = getById(constructionUpdate.getId());
        updateRetrievedEntity(constructionUpdate, construction);

        return ConstructionMapper.convertConstructionIntoConstructionDTO(save(construction));
    }

    @Transactional
    public void deleteOutletProduct(Integer id) {
        Construction construction = getById(id);
        repository.delete(construction);
    }

    private void updateRetrievedEntity(ConstructionDTO constructionUpdate, Construction construction) {
        ConstructionMapper.updateConstruction(constructionUpdate, construction);
    }

}
