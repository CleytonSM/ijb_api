package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "tb_funcao")
@Entity
public class Authority {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_funcao")
    private Integer id;
    @Column(name = "nm_funcao", unique = true, length = 60)
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "authority")
    private List<User> user;

    public Authority(Role role) {
        this.role = role;
    }
}
