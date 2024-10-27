package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.helpers.OutletProductHelper;
import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.OutletProduct;
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
        OutletProduct outletProduct = OutletProductHelper
                .convertOutletProductCreateDTOIntoOutletProduct(outletProductCreate);
        outletProduct = save(outletProduct);

        return OutletProductHelper.convertOutletProductIntoOutletProductDTO(outletProduct);
    }

    public List<OutletProductDTO> getAllOutletProducts() {
        return OutletProductHelper.convertListOfOutletProductIntoListOfOutletProductDTO(repository.findAll());
    }

    public List<OutletProductDTO> getAllOutletProductsByFilter(String nameOrDescription) {
        List<OutletProduct> outletProducts = repository.findAllByOutletProductName(nameOrDescription);
        if (!outletProducts.isEmpty()) {
            return OutletProductHelper.convertListOfOutletProductIntoListOfOutletProductDTO(outletProducts);
        }

        outletProducts = repository.findAllByOutletProductDescription(nameOrDescription);
        if(!outletProducts.isEmpty()) {
            return OutletProductHelper.convertListOfOutletProductIntoListOfOutletProductDTO(outletProducts);
        }

        throw new EntityNotFoundException("There aren't products with this name/description");
    }

    @Transactional
    public OutletProductDTO updateOutletProducts(OutletProductDTO outletProductUpdate) {
        OutletProduct outletProduct = OptionalHelper.getOptionalEntity(repository
                .findById(outletProductUpdate.getId()));
        outletProduct = OutletProductHelper.updateOutletProduct(o)
    }
}
