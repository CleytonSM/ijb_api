package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_visitas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_visita")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_beneficiario")
    private Beneficiary beneficiary;
    @Column(name = "dt_visita")
    private LocalDateTime visitDate;
    @Column(name = "relatorio_visita", length = 500)
    private String visitReport;
    @Column(name = "foto1")
    @Lob
    private byte[] photo1;
    @Column(name = "foto2")
    @Lob
    private byte[] photo2;
    @Column(name = "foto3")
    @Lob
    private byte[] photo3;
    @Column(name = "foto4")
    @Lob
    private byte[] photo4;
    @Column(name = "foto5")
    @Lob
    private byte[] photo5;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}
