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

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_beneficiario")
@Data
public class Beneficiary {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_beneficiario")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private User user;
    @Column(name = "dt_atualizacao")
    private LocalDateTime updatedAt;
    @Column(name = "indicacao")
    private String indication;
    @Column(name = "tipo_residencia")
    private String residenceType;
    @Column(name = "possui_terreno")
    private Boolean hasTerrain;
    @Column(name = "dt_registro")
    private LocalDateTime createdAt;
}
