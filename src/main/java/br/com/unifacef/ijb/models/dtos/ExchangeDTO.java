package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDTO {
    private Integer id;
    private OutletProductDTO outletProduct;
    private String exchangesDescription;
}
