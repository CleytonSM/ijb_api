package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class MovementCreateDTO {
    private ReceiptCreateDTO receipt;
    private ExpenseDTO expense;
}
