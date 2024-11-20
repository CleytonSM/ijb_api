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

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_trocas")
@AllArgsConstructor
@NoArgsConstructor
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_troca")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_prod_outlet")
    private OutletProduct outletProduct;
    @Column(name = "ds_troca", length = 100)
    private String exchangesDescription;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Exchange(OutletProduct outletProduct, String exchangesDescription) {
        this.outletProduct = outletProduct;
        this.exchangesDescription = exchangesDescription;
    }
}
