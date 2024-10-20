package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_contato_usuario")
@Data
public class UserContact {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_contato")
    private List<Contact> contacts;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usario")
    private List<User> users;
}
