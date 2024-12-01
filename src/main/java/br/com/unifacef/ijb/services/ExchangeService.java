//package br.com.unifacef.ijb.services;
//
//import br.com.unifacef.ijb.helpers.OptionalHelper;
//import br.com.unifacef.ijb.models.dtos.ExchangeCreateDTO;
//import br.com.unifacef.ijb.models.dtos.ExchangeDTO;
//import br.com.unifacef.ijb.models.entities.Exchange;
//import br.com.unifacef.ijb.repositories.ExchangeRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ExchangeService {
//    @Autowired
//    private ExchangeRepository repository;
//
//    public Exchange save(Exchange exchange) {
//        return repository.save(exchange);
//    }
//
//    public Exchange getById(Integer id) {
//        return OptionalHelper.getOptionalEntity(repository.findById(id));
//    }
//
//    @Transactional
//    public ExchangeDTO createExchange(ExchangeCreateDTO exchangeCreate) {
//        Exchange exchange = ExchangeMapper.convertExchangeCreateDTOIntoExchange(exchangeCreate);
//
//        return ExchangeMapper.convertExchangeIntoExchangeDTO(save(exchange));
//    }
//
//    public List<ExchangeDTO> getAllExchanges() {
//        return ExchangeMapper.convertListOfExchangeIntoListOfExchangeDTO(repository.findAll());
//    }
//
//    @Transactional
//    public ExchangeDTO updateExchange(ExchangeDTO exchangeUpdate) {
//        Exchange exchange = getById(exchangeUpdate.getId());
//        updateRetrievedEntity(exchangeUpdate, exchange);
//
//        return ExchangeMapper.convertExchangeIntoExchangeDTO(save(exchange));
//    }
//
//    private void updateRetrievedEntity(ExchangeDTO exchangeUpdate, Exchange exchange) {
//        ExchangeMapper.updateExchange(exchangeUpdate, exchange);
//    }
//
//    public List<ExchangeDTO> findByFilter(String search) {
//        List<Exchange> exchanges = findExchangesBySearch(search);
//        if(Optional.ofNullable(exchanges).isPresent() && !exchanges.isEmpty()) {
//            return ExchangeMapper.convertListOfExchangeIntoListOfExchangeDTO(exchanges);
//        }
//
//        return null;
//    }
//
//    private List<Exchange> findExchangesBySearch(String search) {
//        return repository.findAllBySearch(search);
//    }
//
//    public void deleteById(Integer id) {
//        repository.delete(getById(id));
//    }
//}
