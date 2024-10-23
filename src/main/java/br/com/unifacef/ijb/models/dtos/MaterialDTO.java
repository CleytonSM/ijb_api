package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class MaterialDTO {
    private Integer id;
    private DonatedMaterialDTO donatedMaterial;
    private PurchasedMaterialDTO purchasedMaterial;
}
