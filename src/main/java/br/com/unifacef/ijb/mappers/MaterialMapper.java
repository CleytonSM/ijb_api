package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.MaterialDTO;
import br.com.unifacef.ijb.models.dtos.MaterialUpdateDTO;
import br.com.unifacef.ijb.models.entities.Material;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialMapper {

    public static MaterialDTO convertMaterialIntoMaterialDTO(Material material) {
        return new MaterialDTO(material.getId(), material.getName(), material.getQuantity(), material.getDescription(),
                material.getOrigin());
    }

    public static List<MaterialDTO> convertListOfMaterialIntoListOfMaterialDTO(
            List<Material> materials) {
        List<MaterialDTO> materialDTOs = new ArrayList<>();

        materials.forEach(material -> materialDTOs.add(convertMaterialIntoMaterialDTO(material)));

        return materialDTOs;
    }
}
