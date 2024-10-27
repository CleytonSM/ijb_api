package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class ExchangeCreateDTO {
    private OutletProductCreateDTO outletProduct;
    private String exchangesDescription;
}
