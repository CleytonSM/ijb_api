package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_voluntario_visita")
public class VolunteerVisit {
    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private Volunteer volunteer;
    @ManyToOne
    @JoinColumn(name = "id_visita")
    private Visit visit;
}
