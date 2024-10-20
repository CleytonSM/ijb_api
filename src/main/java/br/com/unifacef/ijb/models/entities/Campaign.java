package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.net.DatagramSocketImpl;
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
    @Column(name = "imagemURL")
    @Lob
    private byte[] imageUrl;    // TODO verificar blob

}
