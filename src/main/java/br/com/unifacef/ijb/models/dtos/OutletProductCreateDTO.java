package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OutletProductCreateDTO {
    private String name;
    private BigDecimal price;
    private String description;
    private OutletProductStatus status;
}
