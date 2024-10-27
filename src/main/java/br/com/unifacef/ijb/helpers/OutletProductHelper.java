package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.OutletProduct;

import java.util.ArrayList;
import java.util.List;

public class OutletProductHelper {
    public static OutletProduct convertOutletProductCreateDTOIntoOutletProduct(
            OutletProductCreateDTO outletProductCreate) {
        return new OutletProduct(DonationHelper.convertDonationCreateDTOIntoDonation(outletProductCreate.getDonation()),
                outletProductCreate.getOutletProductName(), outletProductCreate.getOutletProductName(),
                outletProductCreate.getStatus());
    }

    public static OutletProductDTO convertOutletProductIntoOutletProductDTO(OutletProduct outletProduct) {
        return new OutletProductDTO(outletProduct.getId(),
                DonationHelper.convertDonationIntoDonationDTO(outletProduct.getDonation()),
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
}
