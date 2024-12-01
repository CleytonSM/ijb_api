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
        if(Optional.ofNullable(material.getDonatedMaterial()).isPresent()) {
           return new MaterialDTO(material.getId(),
                   DonatedMaterialMapper.convertDonatedMaterialIntoDonatedMaterialDTO(material.getDonatedMaterial()));
        }

        return new MaterialDTO(material.getId(),
                PurchasedMaterialMapper.convertPurchasedMaterialIntoPurchasedMaterialDTO(material.getPurchasedMaterial())
        );
    }

    public static List<MaterialDTO> convertListOfMaterialIntoListOfMaterialDTO(
            List<Material> materials) {
        List<MaterialDTO> materialDTOs = new ArrayList<>();

        for (Material material : materials) {
            materialDTOs.add(convertMaterialIntoMaterialDTO(material));
        }

        return materialDTOs;
    }

    public static Material updateMaterial(MaterialUpdateDTO materialUpdate, Material material) {
        if(Optional.ofNullable(material.getDonatedMaterial()).isPresent()) {
            material.getDonatedMaterial().setMaterialName(materialUpdate.getMaterialName());
            material.getDonatedMaterial().setMaterialQuantity(materialUpdate.getQuantity());
            material.getDonatedMaterial().setDescription(materialUpdate.getDescription());
            material.getDonatedMaterial().setUpdatedAt(LocalDateTime.now());
        }

        if(Optional.ofNullable(material.getPurchasedMaterial()).isPresent()) {
            material.getPurchasedMaterial().setMaterialName(materialUpdate.getMaterialName());
            material.getPurchasedMaterial().setMaterialQuantity(materialUpdate.getQuantity());
            material.getPurchasedMaterial().setDescription(materialUpdate.getDescription());
            material.getPurchasedMaterial().setUpdatedAt(LocalDateTime.now());
        }

        return material;
    }

}
