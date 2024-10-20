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
    @Column(name = "dt_inicio")
    private LocalDateTime startedAt;
    @Column(name = "dt_final")
    private LocalDateTime endedAt;
    @Column(name = "objetivo")
    private String objective;
}
