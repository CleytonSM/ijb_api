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
@Table(name = "tb_noticia")
@Data
public class News {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_noticia")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_publicacao")
    private Post post;
    @Column(name = "titulo")
    private String title;
    @Column(name = "dt_noticia")
    private LocalDateTime newsDate;
    @Column(name = "conteudo")
    private String content;
}
