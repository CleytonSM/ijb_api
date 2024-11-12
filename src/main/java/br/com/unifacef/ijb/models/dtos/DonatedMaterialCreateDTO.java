package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class DonatedMaterialCreateDTO {
    private DonationCreateDTO donation;
    private String materialName;
    private String materialQuantity;
}
