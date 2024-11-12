package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseDTO {
    private Integer id;
    private String expenseType;
    private BigDecimal expenseValue;
    private LocalDateTime expenseDate;
}