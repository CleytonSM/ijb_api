package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.SaleMapper;
import br.com.unifacef.ijb.models.dtos.SaleCreateDTO;
import br.com.unifacef.ijb.models.dtos.SaleDTO;
import br.com.unifacef.ijb.models.entities.Sale;
import br.com.unifacef.ijb.repositories.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;
    @Autowired
    private OutletProductService outletProductService;

    public Sale save(Sale sale) {
        return repository.save(sale);
    }

    public Sale getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public SaleDTO createSale(SaleCreateDTO saleCreate) {
        Sale sale = SaleMapper.convertSaleCreateDTOIntoSale(saleCreate);

        return SaleMapper.convertSaleIntoSaleDTO(save(sale));
    }

    public List<SaleDTO> getAllSales() {
        return SaleMapper.convertListOfSaleIntoListOfSaleDTO(repository.findAll());
    }

    @Transactional
    public SaleDTO updateOutletProduct(SaleDTO saleUpdate) {
        Sale sale = getById(saleUpdate.getId());
        updateRetrievedEntity(saleUpdate, sale);

        return SaleMapper.convertSaleIntoSaleDTO(save(sale));
    }

    @Transactional
    public void deleteSale(Integer id) {
        Sale sale = getById(id);
        outletProductService.deleteOutletProduct(sale.getOutletProduct().getId());
    }

    private void updateRetrievedEntity(SaleDTO saleUpdate, Sale sale) {
        SaleMapper.updateSale(saleUpdate, sale);
    }
}
