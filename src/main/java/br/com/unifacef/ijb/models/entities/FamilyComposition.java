package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

@Data
@Table(name = "tb_comp_familiar")
@Entity
public class FamilyComposition {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    private String cpf;
    @ManyToOne()
    @JoinColumn(name = "id_beneficiario")
    private Beneficiary beneficiary;
    @Column(name = "rg")
    private String rg;
    @Column(name = "escolaridade")
    private String education;
    @Column(name = "valor_renda")
    private double Income;
    @Column(name="origem_renda")
    private String sourceIncome;
    @Column(name="problemas_saude")
    private String healthProblem;
}
