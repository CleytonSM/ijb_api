package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.MaterialOrigin;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MaterialCreateDTO implements Serializable {
    private String name;
    private Integer quantity;
    private String description;
    private BigDecimal price;
    private MaterialOrigin origin;
}
