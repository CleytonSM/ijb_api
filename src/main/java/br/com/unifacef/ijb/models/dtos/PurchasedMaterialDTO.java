package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class PurchasedMaterialDTO {
    private Integer id;
    private String materialName;
    private Integer materialQuantity;
}
