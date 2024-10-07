package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_contato")
@Entity
public class Contact {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_contato")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;
    @Column(name = "telefone", unique = true, length = 15)
    private String telefone;
    @Column(name = "email", unique = true, length = 60)
    private String email;
    @Column(name = "ativo")
    private Boolean active;
}
