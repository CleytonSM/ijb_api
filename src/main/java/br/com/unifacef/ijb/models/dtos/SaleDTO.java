package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDTO {
    private Integer id;
    private OutletProductDTO outletProduct;
    private BigDecimal saleValue;
    private String saleDescription;
}
