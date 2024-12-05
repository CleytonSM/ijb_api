package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleCreateDTO {
    private OutletProductDTO outletProduct;
    private BigDecimal saleValue;
    private String saleDescription;
}

