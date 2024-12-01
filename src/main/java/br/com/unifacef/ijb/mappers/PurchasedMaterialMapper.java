package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.PurchasedMaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.PurchasedMaterialDTO;
import br.com.unifacef.ijb.models.entities.PurchasedMaterial;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PurchasedMaterialMapper {

    public static PurchasedMaterial convertPurchasedMaterialCreateDTOIntoPurchasedMaterial(
            PurchasedMaterialCreateDTO purchasedMaterialCreate) {
        return new PurchasedMaterial(purchasedMaterialCreate.getMaterialName(),
                purchasedMaterialCreate.getMaterialQuantity(),
                purchasedMaterialCreate.getDescription(),
                LocalDateTime.now());
    }

    public static PurchasedMaterialDTO convertPurchasedMaterialIntoPurchasedMaterialDTO(PurchasedMaterial purchasedMaterial) {
        return new PurchasedMaterialDTO(
                purchasedMaterial.getId(),
                purchasedMaterial.getMaterialName(),
                purchasedMaterial.getMaterialQuantity()
        );
    }

    public static List<PurchasedMaterialDTO> convertListOfPurchasedMaterialIntoListOfPurchasedMaterialDTO(
            List<PurchasedMaterial> purchasedMaterials) {
        List<PurchasedMaterialDTO> purchasedMaterialDTOs = new ArrayList<>();

        purchasedMaterials.forEach(purchasedMaterial -> purchasedMaterialDTOs.
                add(convertPurchasedMaterialIntoPurchasedMaterialDTO(purchasedMaterial)));

        return purchasedMaterialDTOs;
    }

    public static void updatePurchasedMaterial(PurchasedMaterialDTO purchasedMaterialUpdate, PurchasedMaterial purchasedMaterial) {
        purchasedMaterial.setMaterialName(purchasedMaterialUpdate.getMaterialName());
        purchasedMaterial.setMaterialQuantity(purchasedMaterialUpdate.getMaterialQuantity());
    }

    public static PurchasedMaterial convertPurchasedMaterialDTOIntoPurchasedMaterial(PurchasedMaterialDTO purchasedMaterialDTO) {
        return new PurchasedMaterial(
                purchasedMaterialDTO.getMaterialName(),
                purchasedMaterialDTO.getMaterialQuantity()
        );
    }
}
