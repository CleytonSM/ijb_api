package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class MaterialCreateDTO implements Serializable {
    private String materialName;
    private Integer quantity;
    private String description;
    private Boolean isDonated;
}
