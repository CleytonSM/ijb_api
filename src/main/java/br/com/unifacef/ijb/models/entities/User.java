package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_usuario")
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "email", unique = true, length = 60)
    private String email;
    @Column(name = "senha", unique = true, length = 40)
    private String password;
    @OneToOne
    private Authority authority;

    public User(String email, String password, Authority authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }
}
