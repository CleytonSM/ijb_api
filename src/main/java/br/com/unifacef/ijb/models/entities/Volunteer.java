package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_voluntarios")
public class Volunteer {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_voluntario")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_tipo_voluntario")
    private VolunteerType volunteerType;
    @Column(name = "cargo_desejado", length = 100)
    private String desiredRole;
    @Column(name = "sobre_voce", length = 240)
    private String aboutYou;
    @Column(name = "hobby", length = 150)
    private String hobby;
    @Column(name = "intencao", length = 200)
    private String intention;
}
