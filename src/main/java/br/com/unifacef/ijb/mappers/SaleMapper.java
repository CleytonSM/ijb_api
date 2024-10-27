package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.SaleCreateDTO;
import br.com.unifacef.ijb.models.dtos.SaleDTO;
import br.com.unifacef.ijb.models.entities.Sale;

import java.util.ArrayList;
import java.util.List;

public class SaleMapper {
    public static Sale convertSaleCreateDTOIntoSale(SaleCreateDTO saleCreate) {
        return new Sale(OutletProductMapper
                .convertOutletProductCreateDTOIntoOutletProduct(saleCreate.getOutletProduct()),
                saleCreate.getSaleValue(), saleCreate.getSaleDescription());
    }

    public static SaleDTO convertSaleIntoSaleDTO(Sale save) {
        return new SaleDTO(save.getId(),
                OutletProductMapper.convertOutletProductIntoOutletProductDTO(save.getOutletProduct()),
                save.getSaleValue(), save.getSaleDescription());
    }

    public static List<SaleDTO> convertListOfSaleIntoListOfSaleDTO(List<Sale> sales) {
        List<SaleDTO> saleDTOs = new ArrayList<>();

        for (Sale sale : sales) {
            saleDTOs.add(convertSaleIntoSaleDTO(sale));
        }

        return saleDTOs;
    }

    public static void updateSale(SaleDTO saleUpdate, Sale sale) {
        sale.setOutletProduct(OutletProductMapper
                .convertOutletProductDTOIntoOutletProduct(saleUpdate.getOutletProduct()));
        sale.setSaleValue(saleUpdate.getSaleValue());
        sale.setSaleDescription(saleUpdate.getSaleDescription());

    }
}
