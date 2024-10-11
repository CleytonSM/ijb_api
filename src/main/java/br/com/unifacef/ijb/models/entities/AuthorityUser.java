package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.security.PublicKey;

@Entity
@Table(name = "tb_funcao_usuario")
@Data
public class AuthorityUser {    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_funcao")
    public Authority authority;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    public User user;
}
