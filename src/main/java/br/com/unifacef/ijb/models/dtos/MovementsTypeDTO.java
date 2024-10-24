package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class MovementsTypeDTO {
    private Integer id;
    private SaleDTO sale;
    private RebateDTO rebate;
    private DonationDTO donation;
    private String movementTypeName;
}