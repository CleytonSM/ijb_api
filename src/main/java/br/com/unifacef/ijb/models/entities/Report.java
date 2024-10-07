package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="tb_relatorio")
@Entity
public class Report {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name="id_relatorio")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "id_beneficiario")
    private Beneficiary beneficiary;
    @ManyToOne
    @JoinColumn(name = "id_visita")
    private Visit visit;
}
