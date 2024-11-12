package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.idClasses.DonationVolunteerId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_doacoes_voluntarios")
@IdClass(DonationVolunteerId.class)
public class DonationVolunteer {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private Volunteer volunteer;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}
