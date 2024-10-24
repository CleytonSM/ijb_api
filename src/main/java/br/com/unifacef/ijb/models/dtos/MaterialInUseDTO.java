package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class MaterialInUseDTO {
    private Integer id;
    private MaterialDTO material;
    private ConstructionDTO construction;
}