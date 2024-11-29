package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
    private Integer id;
    private PurchasedMaterialDTO purchasedMaterialDTO;
    private ConstructionDTO constructionDTO;
    private LocalDateTime receiptDate;
    private LocalDateTime expiryDate;
}