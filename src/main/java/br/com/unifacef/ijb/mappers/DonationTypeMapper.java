package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.DonationTypeCreateDTO;
import br.com.unifacef.ijb.models.dtos.DonationTypeDTO;
import br.com.unifacef.ijb.models.entities.DonationType;

public class DonationTypeMapper {
    public static DonationType convertDonationTypeCreateDTOIntoDonationType(DonationTypeCreateDTO donationTypeCreate) {
        return new DonationType(donationTypeCreate.getTypeDonationName());
    }

    public static DonationTypeDTO convertDonationTypeIntoDonationTypeDTO(DonationType donationType) {
        return new DonationTypeDTO(donationType.getId(), donationType.getTypeDonationName());
    }

    public static DonationType convertDonationTypeDTOIntoDonationType(DonationTypeDTO donationType) {
        return new DonationType(donationType.getTypeDonationName());
    }
}
