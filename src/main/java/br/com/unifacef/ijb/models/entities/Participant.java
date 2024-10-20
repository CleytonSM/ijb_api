package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_participantes")
@Entity
public class Participant {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_participante")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private User user;

}
