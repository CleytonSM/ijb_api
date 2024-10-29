package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.ExchangeMapper;
import br.com.unifacef.ijb.models.dtos.ExchangeCreateDTO;
import br.com.unifacef.ijb.models.dtos.ExchangeDTO;
import br.com.unifacef.ijb.models.entities.Exchange;
import br.com.unifacef.ijb.repositories.ExchangeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRepository repository;
    @Autowired
    private OutletProductService outletProductService;

    public Exchange save(Exchange exchange) {
        return repository.save(exchange);
    }

    public Exchange getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public ExchangeDTO createExchange(ExchangeCreateDTO exchangeCreate) {
        Exchange exchange = ExchangeMapper.convertExchangeCreateDTOIntoExchange(exchangeCreate);

        return ExchangeMapper.convertExchangeIntoExchangeDTO(save(exchange));
    }

    public List<ExchangeDTO> getAllExchanges() {
        return ExchangeMapper.convertListOfExchangeIntoListOfExchangeDTO(repository.findAll());
    }

    @Transactional
    public ExchangeDTO updateExchange(ExchangeDTO exchangeUpdate) {
        Exchange exchange = getById(exchangeUpdate.getId());
        updateRetrievedEntity(exchangeUpdate, exchange);

        return ExchangeMapper.convertExchangeIntoExchangeDTO(save(exchange));
    }

    @Transactional
    public void deleteExchange(Integer id) {
        Exchange exchange = getById(id);
        outletProductService.deleteOutletProduct(exchange.getOutletProduct().getId());
    }

    private void updateRetrievedEntity(ExchangeDTO exchangeUpdate, Exchange exchange) {
        ExchangeMapper.updateExchange(exchangeUpdate, exchange);
    }
}
