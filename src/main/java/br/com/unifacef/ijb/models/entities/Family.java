package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_familia")
@Entity
public class Family {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    private String id;
    @ManyToOne()
    @JoinColumn(name = "id_beneficiario")
    private Beneficiary beneficiary;
    @Column(name = "nm_familia", length = 60)
    private String familyName;
    @Column(name = "parentesco", length = 30)
    private String kinship;
    @Column(name = "escolaridade", length = 40)
    private String scholarity;
}
