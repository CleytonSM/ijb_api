package br.com.unifacef.ijb.models.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReceiptDTO {
    private Integer id;
    private String receiptOrigin;
    private String receiptType;
    private BigDecimal receiptValue;
    private LocalDateTime receiptDate;
}

