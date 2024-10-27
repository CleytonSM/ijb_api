package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_abatimentos")
@AllArgsConstructor
@NoArgsConstructor
public class Rebate {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_abatimento")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_troca")
    private Exchange exchange;
    @Column(name = "ds_abatimento", length = 100)
    private String description;
    @Column(name = "valor_abatimento")
    private BigDecimal rebateValue;

    public Rebate(Exchange exchange, String description, BigDecimal rebateValue) {
        this.exchange = exchange;
        this.description = description;
        this.rebateValue = rebateValue;
    }
}
