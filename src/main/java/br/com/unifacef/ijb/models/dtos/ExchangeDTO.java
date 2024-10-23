package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class ExchangeDTO {
    private Integer id;
    private OutletProductDTO outletProduct;
    private String exchangesDescription;
}
