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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visita")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_beneficiario")
    private Beneficiary beneficiary;
    @Column(name = "dt_visita")
    private LocalDateTime visitDate;
    @Column(name = "relatorio", length = 200)
    private String report;
    @Column(name = "imagem1")
    @Lob
    private byte[] firstImage;
    @Column(name = "imagem2")
    @Lob
    private byte[] secondImage;
    @Column(name = "imagem3")
    @Lob
    private byte[] thirdImage;
    @Column(name = "imagem4")
    @Lob
    private byte[] fourthImage;
    @Column(name = "imagem5")
    @Lob
    private byte[] fifthImage;

}
