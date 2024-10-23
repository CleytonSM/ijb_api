package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class DonationDTO {
    private Integer id;
    private DonationTypeDTO donationType;
}
