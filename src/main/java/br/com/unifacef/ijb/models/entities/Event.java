package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_eventos")
@Entity
public class Event {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_evento")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_participante")
    private Participant participant;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_voluntarioApoiador")
    private Volunteer volunteer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_noticia")
    private News news;
    @Column(name = "nm_evento", length = 20)
    private String eventName;
    @Column(name = "dt_evento")
    private LocalDateTime eventDate;
    @Column(name = "local_evento", length = 100)
    private String eventLocation;
    @Column(name = "descrição_evento", length = 100)
    private String eventDescription;

}
