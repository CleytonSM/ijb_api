package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.ExchangeCreateDTO;
import br.com.unifacef.ijb.models.dtos.ExchangeDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.Exchange;
import br.com.unifacef.ijb.models.entities.OutletProduct;

import java.util.ArrayList;
import java.util.List;

public class ExchangeMapper {
    public static Exchange convertExchangeCreateDTOIntoExchange(ExchangeCreateDTO exchangeCreate) {
        return new Exchange(OutletProductMapper
                .convertOutletProductCreateDTOIntoOutletProduct(exchangeCreate.getOutletProduct()),
                exchangeCreate.getExchangesDescription());
    }

    public static ExchangeDTO convertExchangeIntoExchangeDTO(Exchange exchange) {
        return new ExchangeDTO(exchange.getId(),
                OutletProductMapper.convertOutletProductIntoOutletProductDTO(exchange.getOutletProduct()),
                exchange.getExchangesDescription());
    }

    public static List<ExchangeDTO> convertListOfExchangeIntoListOfExchangeDTO(List<Exchange> exchanges) {
        List<ExchangeDTO> exchangeDTOs = new ArrayList<>();

        for (Exchange exchange : exchanges) {
            exchangeDTOs.add(convertExchangeIntoExchangeDTO(exchange));
        }

        return exchangeDTOs;
    }

    public static void updateExchange(ExchangeDTO exchangeUpdate, Exchange exchange) {
        exchange.setOutletProduct(OutletProductMapper
                .convertOutletProductDTOIntoOutletProduct(exchangeUpdate.getOutletProduct()));
        exchangeUpdate.setExchangesDescription(exchangeUpdate.getExchangesDescription());
    }

    public static Exchange convertExchangeDTOIntoExchange(ExchangeDTO exchange) {
        return new Exchange(OutletProductMapper.convertOutletProductDTOIntoOutletProduct(exchange.getOutletProduct()),
                exchange.getExchangesDescription());
    }
}
