package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class ExchangedMaterialCreateDTO {
    private MaterialCreateDTO material;
    private ExchangeCreateDTO exchange;
}
