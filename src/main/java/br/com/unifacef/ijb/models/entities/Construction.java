package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_obras")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Construction {
     @Id
     @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
     @Column(name = "id_construcao")
     private Integer id;
     @OneToOne
     @JoinColumn(name = "id_endereco")
     private Address address;
     @Column(name="descricao")
     private String description;
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

     public Construction(Address address, String description, LocalDateTime startDate, LocalDateTime endDate, String constructionStatus, BigDecimal estimatedCost, BigDecimal totalCost) {
          this.address = address;
          this.description = description;
          this.startDate = startDate;
          this.endDate = endDate;
          this.constructionStatus = constructionStatus;
          this.estimatedCost = estimatedCost;
          this.totalCost = totalCost;

     }

}
