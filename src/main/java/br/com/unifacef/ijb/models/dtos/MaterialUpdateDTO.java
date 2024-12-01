package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.MaterialOrigin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUpdateDTO {
    private Integer id;
    private String name;
    private Integer quantity;
    private String description;
    private MaterialOrigin origin;
}
