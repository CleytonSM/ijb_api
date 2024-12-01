package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_produtos_outlet")
@AllArgsConstructor
@NoArgsConstructor
@Filter(name = "statusFilter", condition = "status != INACTIVE")
public class OutletProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod_outlet")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @Column(name = "nm_produto_outlet", length = 60)
    private String outletProductName;
    @Column(name = "ds_prod_outlet")
    private String description;
    @Column(name = "status", length = 20)
    @Enumerated(EnumType.STRING)
    private OutletProductStatus status;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public OutletProduct(String outletProductName, String description, OutletProductStatus status, LocalDateTime createdAt) {
        this.outletProductName = outletProductName;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public OutletProduct(Integer id, String outletProductName, String description, OutletProductStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.outletProductName = outletProductName;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public OutletProduct(Integer id, String outletProductName, String description, OutletProductStatus status) {
        this.id = id;
        this.outletProductName = outletProductName;
        this.description = description;
        this.status = status;
    }
}
