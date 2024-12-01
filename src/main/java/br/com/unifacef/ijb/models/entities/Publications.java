package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_publicacoes")
@Entity
public class Publications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacao")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_voluntario")
    private Volunteer volunteer;
    @Column(name = "data_publicacao")
    private LocalDateTime postDate;
    @Column(name = "visibilidade")
    private Boolean visibility;
    @Column(name = "autor_publicacao", length = 30)
    private String authorPublication;

}
