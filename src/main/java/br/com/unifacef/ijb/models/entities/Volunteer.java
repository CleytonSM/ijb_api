package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_voluntario")
public class Volunteer {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_voluntario")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;
    @Column(name = "dt_efetivacao")
    private LocalDateTime actualizedAt;
    @Column(name = "dt_desligamento")
    private LocalDateTime shutdownAt;
    @Column(name = "dt_atualizacao")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "volunteer")
    private List<VolunteerVisit> volunteerVisits;
}
