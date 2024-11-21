package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementDTO {
    private Integer id;
    private ReceiptDTO receipt;
    private ExpenseDTO expense;
}