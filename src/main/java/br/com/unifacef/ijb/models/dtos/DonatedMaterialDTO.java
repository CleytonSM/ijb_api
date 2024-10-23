package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class DonatedMaterialDTO {
    private Integer id;
    private DonationDTO donation;
    private String materialName;
    private String materialQuantity;
}
