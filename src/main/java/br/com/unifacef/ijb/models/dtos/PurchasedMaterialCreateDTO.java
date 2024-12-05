package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasedMaterialCreateDTO {
    private String materialName;
    private Integer materialQuantity;
    private String description;
}
