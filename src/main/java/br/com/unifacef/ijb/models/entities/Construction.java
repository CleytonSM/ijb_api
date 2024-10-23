package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_construcoes")
@Data
public class Construction {
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
