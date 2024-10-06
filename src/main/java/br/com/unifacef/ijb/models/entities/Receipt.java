package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_receita")
@Entity
public class Receipt {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_receita")
    private Integer id;
    @Column(name = "origem_receita", length = 100)
    private String receiptOrigin;
    @Column(name = "tipo_receita", length = 60)
    private String receiptType;
    @Column(name = "valor_receita")
    private BigDecimal receiptValue;
    @Column(name = "dt_receita")
    private LocalDateTime receiptDate;
}
