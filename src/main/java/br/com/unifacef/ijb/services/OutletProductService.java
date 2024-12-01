package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.ExchangeMapper;
import br.com.unifacef.ijb.mappers.OutletProductMapper;
import br.com.unifacef.ijb.mappers.RebateMapper;
import br.com.unifacef.ijb.mappers.SaleMapper;
import br.com.unifacef.ijb.models.dtos.ExchangeCreateDTO;
import br.com.unifacef.ijb.models.dtos.ExchangeDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductFilterResponseDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductUpdateDTO;
import br.com.unifacef.ijb.models.dtos.RebateCreateDTO;
import br.com.unifacef.ijb.models.dtos.RebateDTO;
import br.com.unifacef.ijb.models.dtos.SaleCreateDTO;
import br.com.unifacef.ijb.models.dtos.SaleDTO;
import br.com.unifacef.ijb.models.entities.Exchange;
import br.com.unifacef.ijb.models.entities.OutletProduct;
import br.com.unifacef.ijb.models.entities.Rebate;
import br.com.unifacef.ijb.models.entities.Sale;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.repositories.OutletProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OutletProductService {
    @Autowired
    private OutletProductRepository repository;
    @Autowired
    private SaleService saleService;
    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private RebateService rebateService;

    public OutletProduct save(OutletProduct outletProduct) {
        return repository.save(outletProduct);
    }

    public OutletProduct getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public void createOutletProduct(OutletProductCreateDTO outletProductCreate) {
        OutletProductStatus outletProductStatus = outletProductCreate.getStatus();

        OutletProduct outletProduct = OutletProductMapper
                .convertOutletProductCreateDTOIntoOutletProduct(outletProductCreate);
        OutletProductDTO outletProductDTO = OutletProductMapper
                .convertOutletProductIntoOutletProductDTO(save(outletProduct));

        if(outletProductStatus.equals(OutletProductStatus.SOLD)) {
            SaleCreateDTO saleCreate = new SaleCreateDTO(outletProductDTO, outletProductCreate.getPrice(),
                    outletProductCreate.getDescription());

            saleService.createSale(saleCreate);
        }

        if(outletProductStatus.equals(OutletProductStatus.EXCHANGED) ||
                outletProductStatus.equals(OutletProductStatus.REBATED)) {
            ExchangeCreateDTO exchangeCreate = new ExchangeCreateDTO(outletProductDTO,
                    outletProductCreate.getDescription());

            ExchangeDTO exchange = exchangeService.createExchange(exchangeCreate);

            if(outletProductStatus.equals(OutletProductStatus.REBATED)) {
                RebateCreateDTO rebateCreate = new RebateCreateDTO(exchange, outletProductCreate.getDescription(),
                        outletProductCreate.getPrice());

                rebateService.createRebate(rebateCreate);
            }
        }
    }


    @Transactional
    public void updateOutletProduct(OutletProductUpdateDTO outletProductUpdate) {

        switch (outletProductUpdate.getStatus()) {
            case ACTIVE -> {
                OutletProduct outletProduct = getById(outletProductUpdate.getId());

                outletProduct.setOutletProductName(outletProductUpdate.getOutletProductName());
                outletProduct.setDescription(outletProductUpdate.getDescription());
                outletProduct.setUpdatedAt(LocalDateTime.now());

                save(outletProduct);
            }
            case SOLD -> {
                Sale sale = saleService.getById(outletProductUpdate.getId());
                SaleDTO saleDTO = SaleMapper.convertSaleIntoSaleDTO(sale);
                saleDTO.setSaleDescription(outletProductUpdate.getDescription());
                saleDTO.setSaleValue(outletProductUpdate.getPrice());
                sale.getOutletProduct().setDescription(outletProductUpdate.getDescription());
                sale.getOutletProduct().setOutletProductName(outletProductUpdate.getOutletProductName());
                sale.getOutletProduct().setUpdatedAt(LocalDateTime.now());
                save(sale.getOutletProduct());

                saleService.updateOutletProduct(saleDTO);
            }
            case EXCHANGED -> {
                Exchange exchange = exchangeService.getById(outletProductUpdate.getId());
                ExchangeDTO exchangeDTO = ExchangeMapper.convertExchangeIntoExchangeDTO(exchange);
                exchangeDTO.setExchangesDescription(outletProductUpdate.getDescription());
                exchange.getOutletProduct().setOutletProductName(outletProductUpdate.getOutletProductName());
                exchange.getOutletProduct().setDescription(outletProductUpdate.getDescription());
                exchange.getOutletProduct().setUpdatedAt(LocalDateTime.now());
                save(exchange.getOutletProduct());

                exchangeService.updateExchange(exchangeDTO);
            }
            case REBATED -> {
                Rebate rebate = rebateService.getById(outletProductUpdate.getId());
                RebateDTO rebateDTO = RebateMapper.convertRebateIntoRebateDTO(rebate);
                rebateDTO.setDescription(outletProductUpdate.getDescription());
                rebateDTO.setRebateValue(outletProductUpdate.getPrice());
                rebate.getExchange().getOutletProduct().setOutletProductName(outletProductUpdate.getOutletProductName());
                rebate.getExchange().getOutletProduct().setDescription(outletProductUpdate.getDescription());
                rebate.getExchange().getOutletProduct().setUpdatedAt(LocalDateTime.now());
                save(rebate.getExchange().getOutletProduct());

                rebateService.updateRebate(rebateDTO);
            }
        }
    }

    @Transactional
    public void deleteOutletProduct(Integer id, OutletProductStatus status) {
        switch (status) {
            case ACTIVE -> repository.delete(getById(id));
            case SOLD -> {
                Sale sale = saleService.getById(id);
                saleService.deleteById(sale.getId());

                repository.deleteById(sale.getOutletProduct().getId());
            }
            case EXCHANGED -> {
                Exchange exchange = exchangeService.getById(id);
                exchangeService.deleteById(exchange.getId());

                repository.deleteById(exchange.getOutletProduct().getId());
            }
            case REBATED -> {
                Rebate rebate = rebateService.getById(id);
                rebateService.deleteById(rebate.getId());

                Exchange exchange = exchangeService.getById(rebate.getExchange().getId());
                exchangeService.deleteById(exchange.getId());

                repository.deleteById(exchange.getOutletProduct().getId());
            }
        }
    }

    private void updateRetrievedEntity(OutletProductDTO outletProductUpdate, OutletProduct outletProduct) {
        OutletProductMapper.updateOutletProduct(outletProductUpdate, outletProduct);
    }

    public OutletProductFilterResponseDTO findByFilter(String search) {
        List<OutletProduct> outletProducts = findOutletProductsBySearch(search);

        OutletProductFilterResponseDTO outletProductFilterResponse = new OutletProductFilterResponseDTO();
        outletProductFilterResponse.setOutletProducts(OutletProductMapper
                .convertListOfOutletProductIntoListOfOutletProductDTO(outletProducts));
        outletProductFilterResponse.setSales(saleService.findByFilter(search));
        outletProductFilterResponse.setExchanges(exchangeService.findByFilter(search));
        outletProductFilterResponse.setRebates(rebateService.findByFilter(search));

        return outletProductFilterResponse;
    }

    public List<OutletProduct> findOutletProductsBySearch(String search) {
        return repository.findAllBySearch(search);
    }
}
