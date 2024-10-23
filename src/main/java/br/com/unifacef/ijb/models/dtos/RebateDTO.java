package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RebateDTO {
    private Integer id;
    private ExchangeDTO exchange;
    private String description;
    private BigDecimal rebateValue;
}
