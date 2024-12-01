package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_voluntarios")
@AllArgsConstructor
@NoArgsConstructor
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

  
  public Volunteer(String desiredRole, String aboutYou, String hobby, String intention) {
        this.desiredRole = desiredRole;
        this.aboutYou = aboutYou;
        this.hobby = hobby;
        this.intention = intention;
    }
}
