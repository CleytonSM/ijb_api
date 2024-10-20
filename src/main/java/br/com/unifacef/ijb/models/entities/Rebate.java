package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_abatimentos")
public class Rebate {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_abatimento")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_troca")
    private Exchanges exchanges;
    @Column(name = "ds_abatimento", length = 100)
    private String description;
    @Column(name = "valor_abatimento")
    private BigDecimal rebateValue;
}
