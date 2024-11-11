package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_familia")
@Entity
public class Familiar {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "id_beneficiario")
    private Beneficiary beneficiary;
    @Column(name = "nm_familia", length = 60)
    private String familiarName;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "parentesco", length = 30)
    private String kinship;
    @Column(name = "escolaridade", length = 40)
    private String scholarity;
    @Column(name = "dt_nascimento")
    private Date birthDate;
    @Column(name = "valor_renda")
    private BigDecimal income;
    @Column(name = "origem_renda", length = 40)
    private String incomeDescription;
    @Column(name = "problemas_de_saude", length = 100)
    private String healthyProblems;
}