package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.idClasses.SponsorEventId;
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

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_patrocinadores_eventos")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SponsorEventId.class)
public class SponsorEvent {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_patrocinador")
    private Sponsor sponsor;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Event event;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}
