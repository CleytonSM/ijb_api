package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutletProductDTO {
    private Integer id;
    private DonationDTO donation;
    private String outletProductName;
    private String outletProductDescription;
    private String status;
}
