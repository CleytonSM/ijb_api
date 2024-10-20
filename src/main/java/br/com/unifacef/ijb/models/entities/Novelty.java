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

@Entity
@Table(name = "tb_novidade")
@Data
public class Novelty {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_novidade")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_noticia")
    private News news;
    @Column(name = "origem")
    private String origin;
    @Column(name = "categoria")
    private String category;
    @Column(name = "destaque")
    private String highlight;
}
