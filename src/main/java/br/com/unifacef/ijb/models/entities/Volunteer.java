package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tb_voluntarios")
public class Volunteer {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_voluntario")
    private Integer id;
    @Column(name = "cargo_desejado")
    private Integer desired_position;
    @Column(name = "data_disponibilidade")
    private LocalDateTime availability_date;
}
