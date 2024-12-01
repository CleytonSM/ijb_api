package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutletProductFilterResponseDTO {
    private List<OutletProductDTO> outletProducts;
    private List<SaleDTO> sales;
    private List<ExchangeDTO> exchanges;
    private List<RebateDTO> rebates;
}
