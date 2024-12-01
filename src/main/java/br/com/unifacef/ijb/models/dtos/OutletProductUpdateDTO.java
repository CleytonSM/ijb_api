package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutletProductUpdateDTO {
    private Integer id;
    private String outletProductName;
    private BigDecimal price;
    private String description;
//    private OutletProductStatus previousStatus;
    private OutletProductStatus status;
}
