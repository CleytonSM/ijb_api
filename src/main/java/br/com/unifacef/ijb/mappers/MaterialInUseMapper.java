package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.DonatedMaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.DonatedMaterialDTO;
import br.com.unifacef.ijb.models.dtos.MaterialInUseCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialInUseDTO;
import br.com.unifacef.ijb.models.entities.Construction;
import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import br.com.unifacef.ijb.models.entities.MaterialInUse;

import java.util.ArrayList;
import java.util.List;

public class MaterialInUseMapper {
    public static MaterialInUse convertMaterialInUseCreateDTOIntoMaterialInUse(
            MaterialInUseCreateDTO materialInUseCreate) {
        return new MaterialInUse(
                MaterialMapper.convertMaterialCreateDTOIntoMaterial(materialInUseCreate.getMaterial()),
                ConstructionMapper.convertConstructionCreateDTOIntoConstruction(materialInUseCreate.getConstruction())
        );
    }

    public static MaterialInUseDTO convertMaterialInUseIntoMaterialInUseDTO(MaterialInUse materialInUse) {
        return new MaterialInUseDTO(
                materialInUse.getId(),
                MaterialMapper.convertMaterialIntoMaterialDTO(materialInUse.getMaterial()),
                ConstructionMapper.convertConstructionIntoConstructionDTO(materialInUse.getConstruction())
        );
    }

    public static List<MaterialInUseDTO> convertListOfMaterialInUseIntoListOfMaterialInUseDTO(
            List<MaterialInUse> materialsInUse) {
        List<MaterialInUseDTO> materialInUseDTOS = new ArrayList<>();

        for (MaterialInUse materialInUse : materialsInUse) {
            materialInUseDTOS.add(convertMaterialInUseIntoMaterialInUseDTO(materialInUse));
        }

        return materialInUseDTOS;
    }

    public static MaterialInUse updateMaterialInUse(MaterialInUseDTO materialInUseUpdate, MaterialInUse materialInUse) {
        materialInUse.setMaterial(MaterialMapper.convertMaterialDTOIntoMaterial(materialInUseUpdate.getMaterial()));
        materialInUse.setConstruction(ConstructionMapper.convertConstructionDTOIntoConstruction(materialInUseUpdate.getConstruction()));

        return materialInUse;
    }

    public static MaterialInUse convertMaterialInUseDTOIntoMaterialInUse(MaterialInUseDTO materialInUseDTO) {
        return new MaterialInUse();
    }

    public static MaterialInUseDTO convertMaterialInUsetIntoMaterialInUseDTO(MaterialInUse materialInUse) {
        return new MaterialInUseDTO(materialInUse.getId(),
                MaterialMapper.convertMaterialIntoMaterialDTO(materialInUse.getMaterial()),
                ConstructionMapper.convertConstructionIntoConstructionDTO(materialInUse.getConstruction())
        );
    }
}
