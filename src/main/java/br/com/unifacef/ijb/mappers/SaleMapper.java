package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.SaleCreateDTO;
import br.com.unifacef.ijb.models.dtos.SaleDTO;
import br.com.unifacef.ijb.models.entities.Sale;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleMapper {
    public static Sale convertSaleCreateDTOIntoSale(SaleCreateDTO saleCreate) {
        return new Sale(OutletProductMapper
                .convertOutletProductDTOIntoOutletProduct(saleCreate.getOutletProduct()),
                saleCreate.getSaleValue(), saleCreate.getSaleDescription(), LocalDateTime.now());
    }

    public static SaleDTO convertSaleIntoSaleDTO(Sale sale) {
        return new SaleDTO(sale.getId(),
                OutletProductMapper.convertOutletProductIntoOutletProductDTO(sale.getOutletProduct()),
                sale.getSaleValue(), sale.getSaleDescription());
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
