package br.com.unifacef.ijb.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class UserInfo {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_funcao")
    private Authority authority;

    @Column(name = "dt_registro")
    private LocalDateTime createdAt;

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

    
}
