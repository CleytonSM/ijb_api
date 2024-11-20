package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_obras")
@Data
public class Construction {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_construcao")
     private Integer id;
     @OneToOne
     @JoinColumn(name = "id_endereco")
     private Address address;
     @Column(name = "dt_inicio")
     private LocalDateTime startDate;
     @Column(name = "dt_termino")
     private LocalDateTime endDate;
     @Column(name = "situacao_construcao")
     private String constructionStatus;
     @Column(name = "custo_estimado")
     private BigDecimal estimatedCost;
     @Column(name = "custo_total")
     private BigDecimal totalCost;
     @Column(name = "dt_criacao")
     private LocalDateTime createdAt;
     @Column(name = "dt_alteracao")
     private LocalDateTime updatedAt;
     @Column(name = "dt_exclusao")
     private LocalDateTime deletedAt;
}
