package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDTO {
    private Integer id;
    private DonationDTO donation;
    private SaleDTO sale;
    private RebateDTO rebate;
    private LocalDateTime receiptDate;
    private LocalDateTime expiryDate;
}

