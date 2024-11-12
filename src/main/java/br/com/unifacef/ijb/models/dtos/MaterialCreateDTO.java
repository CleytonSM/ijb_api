package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class MaterialCreateDTO {
    private DonatedMaterialCreateDTO donatedMaterial;
    private PurchasedMaterialCreateDTO purchasedMaterial;
}
