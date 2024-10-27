package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.DonatedMaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.DonatedMaterialDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.DonatedMaterial;
import br.com.unifacef.ijb.models.entities.OutletProduct;

import java.util.ArrayList;
import java.util.List;

public class DonatedMaterialMapper {
    public static DonatedMaterial convertDonatedMaterialCreateDTOIntoDonatedMaterial(
            DonatedMaterialCreateDTO donatedMaterialCreate){
        return new DonatedMaterial(DonationMapper.convertDonationCreateDTOIntoDonation(donatedMaterialCreate.getDonation()),
                donatedMaterialCreate.getMaterialName(), donatedMaterialCreate.getMaterialQuantity());
    }

    public static DonatedMaterialDTO convertDonatedMaterialtIntoDonatedMaterialDTO(DonatedMaterial donatedMaterial) {
        return new DonatedMaterialDTO(donatedMaterial.getId(),
                DonationMapper.convertDonationIntoDonationDTO(donatedMaterial.getDonation()),
                donatedMaterial.getMaterialName(), donatedMaterial.getMaterialQuantity());
    }

    public static List<DonatedMaterialDTO> convertListOfDonatedMaterialIntoListOfDonatedMaterialDTO(
            List<DonatedMaterial> donatedMaterials) {
        List<DonatedMaterialDTO> donatedMaterialDTOS = new ArrayList<>();

        for (DonatedMaterial donatedMaterial : donatedMaterials) {
            donatedMaterialDTOS.add(convertDonatedMaterialtIntoDonatedMaterialDTO(donatedMaterial));
        }

        return donatedMaterialDTOS;
    }

    public static DonatedMaterial updateDonatedMaterial(DonatedMaterialDTO donatedMaterialUpdate, DonatedMaterial donatedMaterial) {
        donatedMaterial.setDonation(DonationMapper.convertDonationDTOIntoDonation(donatedMaterialUpdate.getDonation()));
        donatedMaterial.setMaterialName(donatedMaterialUpdate.getMaterialName());
        donatedMaterial.setMaterialQuantity(donatedMaterial.getMaterialQuantity());

        return donatedMaterial;
    }
}
