package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipos_doacoes")
public class DonationType {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_doacao")
    private Integer Id;
    @Column(name = "nm_tipo_doacao")
    private String Type_Donation_Name;
}
