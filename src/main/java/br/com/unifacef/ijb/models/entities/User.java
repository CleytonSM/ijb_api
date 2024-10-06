package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "tb_usuario")
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "nome")
    private String name;
    @Column(name = "sobrenome")
    private String lastName;
    @Column(name = "data_nascimento")
    private LocalDateTime birthdayDate;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "ativo")
    private Boolean active;
    @Column(name = "dt_registro")
    private LocalDateTime createdAt;
    @Column(name = "email", unique = true, length = 60)
    private String email;
    @Column(name = "senha", length = 30)
    private String password;
    @Column(name = "dt_atualizacao")
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_auth")
    private Authority authority;
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    public User(String email, String password, Authority authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }
}
