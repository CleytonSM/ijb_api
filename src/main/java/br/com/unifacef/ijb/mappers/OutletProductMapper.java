package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.entities.OutletProduct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OutletProductMapper {
//    public static OutletProduct convertOutletProductCreateDTOIntoOutletProduct(
//            OutletProductCreateDTO outletProductCreate) {
//        return new OutletProduct(outletProductCreate.getName(), outletProductCreate.getDescription(),
//                outletProductCreate.getStatus(), LocalDateTime.now());
//    }
//
//    public static OutletProductDTO convertOutletProductIntoOutletProductDTO(OutletProduct outletProduct) {
//        return new OutletProductDTO(outletProduct.getId(), outletProduct.getOutletProductName(), outletProduct.getStatus());
//    }
//
    public static List<OutletProductDTO> convertListOfOutletProductIntoListOfOutletProductDTO(
            List<OutletProduct> outletProducts) {
        List<OutletProductDTO> outletProductDTOs = new ArrayList<>();

        outletProducts.forEach(outletProduct -> outletProductDTOs.add(convertOutletProductIntoOutletProductDTO(outletProduct)));

        return outletProductDTOs;
    }

    private static OutletProductDTO convertOutletProductIntoOutletProductDTO(OutletProduct outletProduct) {
        return new OutletProductDTO(outletProduct.getId(), outletProduct.getName(), outletProduct.getDescription(),
                outletProduct.getPrice(), outletProduct.getStatus());
    }
//
//    public static void updateOutletProduct(OutletProductDTO outletProductUpdate, OutletProduct outletProduct) {
//        outletProduct.setDonation(DonationMapper.convertDonationDTOIntoDonation(outletProductUpdate.getDonation()));
//        outletProduct.setOutletProductName(outletProductUpdate.getOutletProductName());
//    }
//
//    public static OutletProduct convertOutletProductDTOIntoOutletProduct(OutletProductDTO outletProduct) {
//        return new OutletProduct(outletProduct.getId(), outletProduct.getOutletProductName(),
//                outletProduct.getOutletProductDescription(), outletProduct.getStatus());
//    }
}
