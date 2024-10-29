package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.DonationCreateDTO;
import br.com.unifacef.ijb.models.dtos.DonationDTO;
import br.com.unifacef.ijb.models.entities.Donation;

public class DonationMapper {
    public static Donation convertDonationCreateDTOIntoDonation(DonationCreateDTO donationCreate) {
        return new Donation(DonationTypeMapper.convertDonationTypeCreateDTOIntoDonationType(donationCreate
                .getDonationType()));
    }

    public static DonationDTO convertDonationIntoDonationDTO(Donation donation) {
        return new DonationDTO(donation.getId(),
                DonationTypeMapper.convertDonationTypeIntoDonationTypeDTO(donation.getDonationType()));
    }

    public static Donation convertDonationDTOIntoDonation(DonationDTO donation) {
        return new Donation(DonationTypeMapper.convertDonationTypeDTOIntoDonationType(donation.getDonationType()));
    }
}
