package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.models.dtos.DonationCreateDTO;
import br.com.unifacef.ijb.models.dtos.DonationDTO;
import br.com.unifacef.ijb.models.entities.Donation;

public class DonationHelper {
    public static Donation convertDonationCreateDTOIntoDonation(DonationCreateDTO donationCreate) {
        return new Donation(DonationTypeHelper.convertDonationTypeCreateDTOIntoDonationType(donationCreate
                .getDonationType()));
    }

    public static DonationDTO convertDonationIntoDonationDTO(Donation donation) {
        return new DonationDTO(donation.getId(),
                DonationTypeHelper.convertDonationTypeIntoDonationTypeDTO(donation.getDonationType()));
    }
}
