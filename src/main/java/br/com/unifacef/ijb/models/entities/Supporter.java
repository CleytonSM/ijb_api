package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_apoiador")
@Data
public class Supporter {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_apoiador")
    private Integer id;
    @Column(name = "cnpj", length = 14)
    private String cnpj;
}
