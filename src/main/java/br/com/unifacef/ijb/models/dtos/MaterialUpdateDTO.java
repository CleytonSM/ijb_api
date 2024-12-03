package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.MaterialOrigin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUpdateDTO {
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private String description;
    private MaterialOrigin origin;
}
