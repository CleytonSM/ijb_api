package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_campanha")
@Data
public class Campaign {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_campanha")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_noticia")
    private News news;
    @Column(name = "nome_campanha", length = 30)
    private String campaignName;
    @Column(name = "data_publicacao")
    private LocalDateTime postDate;
    @Column(name = "objetivo", length = 150)
    private String objective;
    @Column(name = "dt_inicial")
    private LocalDateTime startedAt;
    @Column(name = "dt_limite")
    private LocalDateTime endedAt;
    @Column(name = "img_campanha")
    @Lob
    private byte[] image;

}
