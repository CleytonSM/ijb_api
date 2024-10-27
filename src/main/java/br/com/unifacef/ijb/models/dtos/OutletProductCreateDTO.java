package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class OutletProductCreateDTO {
    private DonationCreateDTO donation;
    private String outletProductName;
    private String outletProductDescription;
    private String status;
}
