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
@Table(name = "tb_noticias")
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_etiqueta")
    private Tags tags;
    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private Volunteer volunteer;
    @Column(name = "img_noticia")
    @Lob
    private byte[] newsImage;
    @Column(name = "dt_publicacao")
    private LocalDateTime localDateTime;
    @Column(name = "status_visibilidade")
    private Boolean viewStatus;
    @Column(name = "autor_noticia", length = 30)
    private String newsAuthor;
    @Column(name = "url_image", length = 800)
    private String imageURL;
    @Column(name = "descricao_noticia")
    private String newsDescription;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}
