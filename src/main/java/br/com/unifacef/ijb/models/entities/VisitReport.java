package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tb_relatorios_visistas")
@Data
@AllArgsConstructor
public class VisitReport {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_visita")
    private Visit visit;
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
