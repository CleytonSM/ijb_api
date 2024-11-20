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

@Data
@Entity
@Table(name = "tb_vendas")
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_prod_outlet")
    private OutletProduct outletProduct;
    @Column(name = "valor_venda")
    private BigDecimal saleValue;
    @Column(name = "ds_venda", length = 100)
    private String saleDescription;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;


    public Sale(OutletProduct outletProduct, BigDecimal saleValue, String saleDescription) {
        this.outletProduct = outletProduct;
        this.saleValue = saleValue;
        this.saleDescription = saleDescription;
    }
}
