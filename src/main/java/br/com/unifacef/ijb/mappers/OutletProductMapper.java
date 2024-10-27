package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.OutletProduct;

import java.util.ArrayList;
import java.util.List;

public class OutletProductMapper {
    public static OutletProduct convertOutletProductCreateDTOIntoOutletProduct(
            OutletProductCreateDTO outletProductCreate) {
        return new OutletProduct(DonationMapper.convertDonationCreateDTOIntoDonation(outletProductCreate.getDonation()),
                outletProductCreate.getOutletProductName(), outletProductCreate.getOutletProductName(),
                outletProductCreate.getStatus());
    }

    public static OutletProductDTO convertOutletProductIntoOutletProductDTO(OutletProduct outletProduct) {
        return new OutletProductDTO(outletProduct.getId(),
                DonationMapper.convertDonationIntoDonationDTO(outletProduct.getDonation()),
                outletProduct.getOutletProductName(), outletProduct.getOutletProductDescription(),
                outletProduct.getStatus());
    }

    public static List<OutletProductDTO> convertListOfOutletProductIntoListOfOutletProductDTO(
            List<OutletProduct> outletProducts) {
        List<OutletProductDTO> outletProductDTOs = new ArrayList<>();

        for (OutletProduct outletProduct : outletProducts) {
            outletProductDTOs.add(convertOutletProductIntoOutletProductDTO(outletProduct));
        }

        return outletProductDTOs;
    }

    public static void updateOutletProduct(OutletProductDTO outletProductUpdate, OutletProduct outletProduct) {
        outletProduct.setDonation(DonationMapper.convertDonationDTOIntoDonation(outletProductUpdate.getDonation()));
        outletProduct.setOutletProductName(outletProductUpdate.getOutletProductName());
        outletProduct.setOutletProductDescription(outletProduct.getOutletProductDescription());
    }

    public static OutletProduct convertOutletProductDTOIntoOutletProduct(OutletProductDTO outletProduct) {
        return new OutletProduct(DonationMapper.convertDonationDTOIntoDonation(outletProduct.getDonation()),
                outletProduct.getOutletProductName(), outletProduct.getOutletProductDescription(),
                outletProduct.getStatus());
    }
}
