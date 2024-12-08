package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.enums.BeneficiaryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_beneficiarios")
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiario")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private User user;
    @Column(name = "nm_representante", length = 60, nullable = false)
    private String name;
    @Column(name = "status")
    private BeneficiaryStatus status; // TODO VERIFICAR ENUM DISSO
    @Column(name = "como_conheceu", length = 200)
    private String meetDescription;
    @Column(name = "indicador", length = 60)
    private String indicatorName;
    @Column(name = "add_info", length = 200)
    private String additionalInfo;
    @Column(name = "tem_terreno")
    private Boolean hasLand;
    @Column(name = "renda_mensal")
    private BigDecimal monthlyIncome;
    @Column(name = "dt_indicacao")
    private LocalDateTime indicationDate;
    @Column(name = "status_moradia")
    private String houseStatus; // TODO VERIFICAR ENUM DISSO
    @Column(name = "decisao_triagem", length = 200)
    private String decisionTriage; // TODO VERIFICAR ENUM DISSO
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}
