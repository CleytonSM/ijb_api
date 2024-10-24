package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @Column(name = "ds_funcao", length = 60)
    @OneToMany(mappedBy = "authority")
    private List<UserInfo> useriInfo;

    public Authority(Role role) {
        this.role = role;
    }
}
