package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_eventos")
@Entity
public class Events {
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
    @Column(name = "descrição_evento")
    private String eventDescription;

}
