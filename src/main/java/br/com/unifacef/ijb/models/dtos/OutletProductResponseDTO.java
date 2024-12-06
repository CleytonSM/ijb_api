package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutletProductResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private String status;
}
