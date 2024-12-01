package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {
    private Integer id;
    private DonatedMaterialDTO donatedMaterial;
    private PurchasedMaterialDTO purchasedMaterial;

    public MaterialDTO(Integer id, DonatedMaterialDTO donatedMaterial) {
        this.id = id;
        this.donatedMaterial = donatedMaterial;
    }

    public MaterialDTO(Integer id, PurchasedMaterialDTO purchasedMaterial) {
        this.id = id;
        this.purchasedMaterial = purchasedMaterial;
    }
}
