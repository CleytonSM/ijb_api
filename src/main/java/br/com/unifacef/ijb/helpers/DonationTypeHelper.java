package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.models.dtos.DonationTypeCreateDTO;
import br.com.unifacef.ijb.models.dtos.DonationTypeDTO;
import br.com.unifacef.ijb.models.entities.DonationType;

public class DonationTypeHelper {
    public static DonationType convertDonationTypeCreateDTOIntoDonationType(DonationTypeCreateDTO donationTypeCreate) {
        return new DonationType(donationTypeCreate.getTypeDonationName());
    }

    public static DonationTypeDTO convertDonationTypeIntoDonationTypeDTO(DonationType donationType) {
        return new DonationTypeDTO(donationType.getId(), donationType.getTypeDonationName());
    }
}
