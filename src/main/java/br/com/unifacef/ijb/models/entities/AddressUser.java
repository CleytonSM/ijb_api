package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.idClasses.AddressUserId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_endereco_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AddressUserId.class)
public class AddressUser {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Address address;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}
