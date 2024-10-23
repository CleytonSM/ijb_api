package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class ExchangedMaterialDTO {
    private MaterialDTO material;
    private ExchangeDTO exchange;
}
