package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_usuarios")
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_funcao")
    private Authority authority;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "foto_perfil")
    @Lob
    private byte[] profilePic;
    @Column(name = "nome", length = 20)
    private String name;
    @Column(name = "sobrenome", length = 40)
    private String lastName;
    @Column(name = "dt_nascimento")
    private LocalDateTime birthdayDate;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "rg", length = 9)
    private String rg;
    @Column(name = "senha", length = 30)
    private String password;
    @Column(name = "dt_registro")
    private LocalDateTime createdAt;
    @Column(name = "ativo")
    private Boolean active;

    public User(String password, Authority authority) {
        this.password = password;
        this.authority = authority;
    }
}
