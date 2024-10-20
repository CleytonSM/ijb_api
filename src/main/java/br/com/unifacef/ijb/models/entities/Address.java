package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_endereco")
@Data
public class Address {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_endereco")
    private Integer id;
    @Column(name = "cep")
    private String cep;
    @Column(name = "rua")
    private String street;
    @Column(name = "nro_casa")
    private String number;
    @Column(name = "bairro")
    private String neighborhood;
    @Column(name = "complemento")
    private String complement;
}
