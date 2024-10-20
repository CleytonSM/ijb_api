package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_contato")
@Data
public class Contact {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_contato")
    private Integer id;
    @Column(name = "celular1", length = 11)
    private String firstPhoneNumber;
    @Column(name = "celular2", length = 11)
    private String secondPhoneNumber;
    @Column(name = "email", length = 60)
    private String email;
}
