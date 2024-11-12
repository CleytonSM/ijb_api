package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class PurchasedMaterialCreateDTO {
    private Integer id;
    private String materialName;
    private String materialQuantity;
}
