package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementsTypeDTO {
    private Integer id;
    private SaleDTO sale;
    private RebateDTO rebate;
    private DonationDTO donation;
    private String movementTypeName;
}