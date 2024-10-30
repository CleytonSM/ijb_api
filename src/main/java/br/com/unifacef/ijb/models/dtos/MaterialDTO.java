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
}
