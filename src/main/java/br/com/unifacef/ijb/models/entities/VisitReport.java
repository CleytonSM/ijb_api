package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_relatorios_visistas")
@Data
public class VisitReport {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_visita")
    private Visit visit;
    @Column(name = "relatorio", length = 200)
    private String report;
    @Column(name = "imagem_visita")
    @Lob
    private byte[] visitImage;
}
