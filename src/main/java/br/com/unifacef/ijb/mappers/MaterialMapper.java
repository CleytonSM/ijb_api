package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.MaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.Material;
import br.com.unifacef.ijb.models.entities.OutletProduct;

import java.util.ArrayList;
import java.util.List;

public class MaterialMapper {
    public static Material convertMaterialCreateDTOIntoMaterial(
            MaterialCreateDTO materialCreate) {
        return new Material(DonatedMaterialMapper.convertDonatedMaterialCreateDTOIntoDonatedMaterial(materialCreate.getDonatedMaterial()),
                PurchasedMaterialMapper.convertPurchasedMaterialCreateDTOIntoPurchasedMaterial(materialCreate.getPurchasedMaterial()));

    }
    public static MaterialDTO convertMaterialIntoMaterialDTO(Material material) {
        return new MaterialDTO(material.getId(),
                DonatedMaterialMapper.convertDonatedMaterialIntoDonatedMaterialDTO(material.getDonatedMaterial()),
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

    public static void updateMaterial(MaterialDTO materialUpdate, Material material) {
        material.setDonatedMaterial(DonatedMaterialMapper.convertDonatedMaterialDTOIntoDonatedMaterial(materialUpdate.getDonatedMaterial()));
        material.setPurchasedMaterial(PurchasedMaterialMapper.convertPurchasedMaterialDTOIntoPurchasedMaterial(materialUpdate.getPurchasedMaterial()));
    }

    public static Material convertMaterialDTOIntoMaterial(MaterialDTO materialDTO) {
        return new Material(
                DonatedMaterialMapper.convertDonatedMaterialDTOIntoDonatedMaterial(materialDTO.getDonatedMaterial()),
                PurchasedMaterialMapper.convertPurchasedMaterialDTOIntoPurchasedMaterial(materialDTO.getPurchasedMaterial())
        );
    }
}
