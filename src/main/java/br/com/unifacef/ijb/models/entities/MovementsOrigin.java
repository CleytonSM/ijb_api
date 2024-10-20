package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_origem_movimentacoes")
public class MovementsOrigin {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_origem")
    private Integer id;
    @Column(name = "nm_origem")
    private String OriginName;
}
