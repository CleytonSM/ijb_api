package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonatedMaterialCreateDTO {
    private DonationCreateDTO donation;
    private String materialName;
    private Integer materialQuantity;
    private String description;

    public DonatedMaterialCreateDTO(String materialName, Integer materialQuantity, String description) {
        this.materialName = materialName;
        this.materialQuantity = materialQuantity;
        this.description = description;
    }
}
