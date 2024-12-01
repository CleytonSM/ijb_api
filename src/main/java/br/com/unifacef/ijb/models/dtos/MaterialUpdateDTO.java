package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUpdateDTO {
    private Integer id;
    private String materialName;
    private Integer quantity;
    private String description;
    private Boolean isDonated;
}
