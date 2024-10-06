package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_visita")
@Data
public class Visit {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_visita")
    private Integer id;
    @Column(name = "dt_visita")
    private LocalDateTime visitDate;
    @Column(name = "realiza")
    private Boolean hasVisited;
    @Column(name = "tempo_entre_registro_e_visita")
    private Integer timeBetweenRegisterAndVisit;
    @OneToMany(mappedBy = "visit")
    private List<VolunteerVisit> volunteerVisits;
}
