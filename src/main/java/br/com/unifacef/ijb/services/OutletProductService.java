package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.OutletProductMapper;
import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductUpdateDTO;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.repositories.OutletProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OutletProductService {
    @Autowired
    private OutletProductRepository repository;

    public OutletProduct save(OutletProduct outletProduct) {
        return repository.save(outletProduct);
    }

    public OutletProduct getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }


    public void createOutletProduct(OutletProductCreateDTO outletProductCreate) {
        OutletProduct outletProduct = new OutletProduct(outletProductCreate.getName(),
                outletProductCreate.getDescription(), outletProductCreate.getStatus(),
                outletProductCreate.getPrice(), LocalDateTime.now());


        save(outletProduct);
    }

    public List<OutletProductDTO> findByFilter() {
        List<OutletProduct> outletProducts = repository.findAll();

        if(outletProducts.isEmpty()){
            return new ArrayList<>();
        }

        return OutletProductMapper.convertListOfOutletProductIntoListOfOutletProductDTO(outletProducts);
    }

    public void deleteOutletProduct(Integer id) {
        repository.delete(getById(id));
    }

    public void updateOutletProduct(Integer id, OutletProductUpdateDTO outletProductUpdate) {
        OutletProduct outletProduct = getById(id);

        outletProduct.setName(outletProductUpdate.getName());
        outletProduct.setDescription(outletProductUpdate.getDescription());
        outletProduct.setPrice(outletProductUpdate.getPrice());
        outletProduct.setStatus(outletProductUpdate.getStatus());
        outletProduct.setUpdatedAt(LocalDateTime.now());

        save(outletProduct);
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
