package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_endereco_usuario")
@Data
public class AddressUser {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Address address;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;
}
