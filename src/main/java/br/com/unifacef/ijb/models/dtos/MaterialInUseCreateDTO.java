package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class MaterialInUseCreateDTO {
    private MaterialCreateDTO material;
    private ConstructionCreateDTO construction;
}
