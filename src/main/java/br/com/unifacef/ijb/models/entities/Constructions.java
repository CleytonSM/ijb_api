package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_construcoes")
@Data
public class Constructions {

        @Id
        @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
        @Column(name = "id_construcao")
        private Integer id;
        @Column(name = "dt_inicio")
        private LocalDateTime startDate;
        @Column(name = "dt_termino")
        private LocalDateTime endDate;
        @Column(name = "situacao_construcao")
        private String constructionStatus;



}
