package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Table(name = "tb_usuarios")
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "senha", length = 30)
    private String password;

    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;
}
