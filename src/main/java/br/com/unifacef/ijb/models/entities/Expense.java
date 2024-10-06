package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_despesa")
@Entity
public class Expense {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_despesa")
    private Integer id;
    @Column(name = "tipo_despesa", length = 60)
    private String expenseType;
    @Column(name = "valor_despesa")
    private BigDecimal expenseValue;
    @Column(name = "dt_despesa")
    private LocalDateTime expenseDate;
}