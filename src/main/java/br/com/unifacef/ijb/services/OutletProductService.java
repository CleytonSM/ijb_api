package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.OutletProductMapper;
import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.repositories.OutletProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutletProductService {
    @Autowired
    private OutletProductRepository repository;

    public OutletProduct save(OutletProduct outletProduct) {
        return repository.save(outletProduct);
    }

    @Transactional
    public OutletProductDTO createOutletProduct(OutletProductCreateDTO outletProductCreate) {
        OutletProduct outletProduct = OutletProductMapper
                .convertOutletProductCreateDTOIntoOutletProduct(outletProductCreate);
        outletProduct = save(outletProduct);

        return OutletProductMapper.convertOutletProductIntoOutletProductDTO(outletProduct);
    }

    public List<OutletProductDTO> getAllOutletProducts() {
        return OutletProductMapper.convertListOfOutletProductIntoListOfOutletProductDTO(repository.findAll());
    }

    public List<OutletProductDTO> getAllOutletProductsByFilter(String nameOrDescription) {
        List<OutletProduct> outletProducts = repository.findAllByOutletProductName(nameOrDescription);
        if (!outletProducts.isEmpty()) {
            return OutletProductMapper.convertListOfOutletProductIntoListOfOutletProductDTO(outletProducts);
        }

        outletProducts = repository.findAllByOutletProductDescription(nameOrDescription);
        if(!outletProducts.isEmpty()) {
            return OutletProductMapper.convertListOfOutletProductIntoListOfOutletProductDTO(outletProducts);
        }

        throw new EntityNotFoundException("There aren't products with this name/description");
    }

    @Transactional
    public OutletProductDTO updateOutletProduct(OutletProductDTO outletProductUpdate) {
        OutletProduct outletProduct = OptionalHelper.getOptionalEntity(repository.findById(outletProductUpdate.getId()));
        updateRetrievedEntity(outletProductUpdate, outletProduct);

        return OutletProductMapper.convertOutletProductIntoOutletProductDTO(save(outletProduct));
    }

    @Transactional
    public void deleteOutletProduct(Integer id) {
        OutletProduct outletProduct = OptionalHelper.getOptionalEntity(repository.findById(id));
        save(changeOutletProductStatus(OutletProductStatus.INACTIVE, outletProduct));
    }

    private void updateRetrievedEntity(OutletProductDTO outletProductUpdate, OutletProduct outletProduct) {
        OutletProductMapper.updateOutletProduct(outletProductUpdate, outletProduct);
    }

    private OutletProduct changeOutletProductStatus(OutletProductStatus status, OutletProduct outletProduct) {
        outletProduct.setStatus(status);

        return outletProduct;
    }
}
