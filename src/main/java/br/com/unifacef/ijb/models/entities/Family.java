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
    @Column(name = "valor_renda")
    private BigDecimal income;
    @Column(name = "origem_renda", length = 40)
    private String incomeDescription;
    @Column(name = "problemas_fisicos-mentais", length = 100)
    private String physicalMentalProblems;
}
