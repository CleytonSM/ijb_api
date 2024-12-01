package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class MovementsTypeCreateDTO {
    private SaleCreateDTO sale;
    private RebateCreateDTO rebate;
    private DonationCreateDTO donation;
    private String movementTypeName;
}
