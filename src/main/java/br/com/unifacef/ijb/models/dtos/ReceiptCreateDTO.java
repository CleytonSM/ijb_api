package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReceiptCreateDTO {
    private DonationDTO donation;
    private SaleCreateDTO sale;
    private RebateCreateDTO rebate;
    private LocalDateTime receiptDate;
    private LocalDateTime expiryDate;
}
