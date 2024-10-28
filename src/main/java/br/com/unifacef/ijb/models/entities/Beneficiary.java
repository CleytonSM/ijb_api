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
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_beneficiarios")
public class Beneficiary {
    public Beneficiary() {
        //TODO Auto-generated constructor stub
    }
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_beneficiario")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private User user;
    @Column(name = "nm_representante", length = 60, nullable = false)
    private String name;
    @Column(name = "status")
    private String status; // TODO VERIFICAR ENUM DISSO
    @Column(name = "como_conheceu", length = 200)
    private String meetDescription;
    @Column(name = "indicador", length = 60)
    private String indicatorName;
    @Column(name = "renda_mensal")
    private BigDecimal monthlyIncome;
    @Column(name = "dt_indicacao")
    private LocalDateTime indicationDate;
    @Column(name = "status_moradia")
    private String houseStatus; // TODO VERIFICAR ENUM DISSO
}
