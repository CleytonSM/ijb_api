package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.idClasses.VoluntaryVisitId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_visitas_voluntarios")
@NoArgsConstructor
@IdClass(VoluntaryVisitId.class)
public class VoluntaryVisit {
    @Id
    @ManyToOne()
    @JoinColumn(name = "id_visita")
    private Visit visit;
    @Id
    @ManyToOne()
    @JoinColumn(name = "id_voluntario")
    private Volunteer volunteer;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}
