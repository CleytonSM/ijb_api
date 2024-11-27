package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_eventos")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_evento")
    private Long id; 

    @Column(name = "nm_evento", length = 100, nullable = false)
    private String eventName; 

    @Column(name = "descrição_evento", length = 255)
    private String eventDescription; 

    @Column(name = "dt_evento")
    private LocalDate eventDate; 

    @Column(name = "status_evento", length = 20)
    private String status; 

}
