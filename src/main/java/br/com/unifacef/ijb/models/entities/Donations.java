package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_doacoes")
public class Donations {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_doacao")
    private Integer Id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_apoiador")
    private Supporter supporter;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_doacao")
    private DonationType donationType;
}
