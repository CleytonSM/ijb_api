package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_notas_fiscais")
@Entity
public class Invoices {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_nota_fiscal")
    private Integer id;
    @Column(name = "cod_fiscal", length = 25)
    private String taxCode;
    @Column(name = "cnpj_fornecedor", length = 14)
    private String cnpjSupplier;
    @Column(name = "valor")
    private BigDecimal value;
    @Column(name = "dt_vencimento")
    private LocalDateTime dueDate;
}
