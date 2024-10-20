package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_situacoes_movimentacoes")
public class MovimentationSituation {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_situacao")
    private Integer id;
    @Column(name = "nm_situacao")
    private String SituationName;
}
