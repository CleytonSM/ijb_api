package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private User user;
    @Column(name = "rua")
    private String street;
    @Column(name = "bairro")
    private String neighborhood;
    @Column(name = "cep")
    private String cep;
    @Column(name = "numero")
    private String number;
    @Column(name = "complemento")
    private String complement;
    @Column(name = "ponto_ref")
    private String referencePoint;
    @Column(name = "ativo")
    private Boolean active;
}
