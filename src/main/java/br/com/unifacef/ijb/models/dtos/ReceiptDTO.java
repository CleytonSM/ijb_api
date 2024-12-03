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
    private LocalDateTime receiptDate;
    private LocalDateTime expiryDate;
}

