package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_patrocinadores")
@Data
public class Sponsor {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_patrocinador")
    private Integer id;
    @Column(name = "nm_patrocinador")
    private String sponsorName;
    @Column(name = "valor_investido")
    private BigDecimal investedValue;
}
