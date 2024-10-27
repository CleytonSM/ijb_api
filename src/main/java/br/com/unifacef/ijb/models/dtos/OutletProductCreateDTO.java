package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import lombok.Data;

@Data
public class OutletProductCreateDTO {
    private DonationCreateDTO donation;
    private String outletProductName;
    private String outletProductDescription;
    private OutletProductStatus status;
}
