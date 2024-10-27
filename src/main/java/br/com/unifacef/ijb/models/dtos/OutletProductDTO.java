package br.com.unifacef.ijb.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutletProductDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private DonationDTO donation;
    private String outletProductName;
    private String outletProductDescription;
    private String status;
}
