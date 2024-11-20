package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.idClasses.UserInfoId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_infos_usuario")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @EmbeddedId
    private UserInfoId id;

    @MapsId("user")
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_funcao")
    private Authority authority;
    @Column(name = "dt_registro")
    private LocalDateTime registeredAt;
    @Column(name = "ativo")
    private Boolean active;
    @Column(name = "rg", length = 9)
    private String rg;
    @Column(name = "foto_perfil")
    @Lob
    private byte[] profilePic;
    @Column(name = "nome", length = 20)
    private String name;
    @Column(name = "sobrenome", length = 40)
    private String lastName;
    @Column(name = "dt_nascimento")
    private LocalDateTime birthdayDate;
    @Column(name = "celular1", length = 11)  
    private String phone1;
    @Column(name = "celular2", length = 11)  
    private String phone2;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public UserInfo(User user, Authority authority, LocalDateTime registeredAt, String rg,
                    byte[] profilePic, String name, String lastName, LocalDateTime birthdayDate, String phone1,
                    LocalDateTime createdAt, LocalDateTime updatedAt, String phone2, LocalDateTime deletedAt) {
        this.user = user;
        this.authority = authority;
        this.registeredAt = registeredAt;
        this.rg = rg;
        this.profilePic = profilePic;
        this.name = name;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
        this.phone1 = phone1;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.phone2 = phone2;
        this.deletedAt = deletedAt;
    }
}
