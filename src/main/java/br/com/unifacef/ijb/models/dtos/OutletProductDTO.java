package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class OutletProductDTO {
    private Integer id;
    private DonationDTO donation;
    private String outletProductName;
    private String outletProductDescription;
}
