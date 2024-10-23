package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_doacoes_voluntarios")
public class DonationVolunteer {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private Volunteer volunteer;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_doacao")
    private Donation donation;
}
