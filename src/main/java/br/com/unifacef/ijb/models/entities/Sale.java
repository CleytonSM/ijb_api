package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_vendas")
public class Sale {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_prod_outlet")
    private OutletProduct outletProduct;
    @Column(name = "valor_venda")
    private BigDecimal saleValue;
    @Column(name = "ds_venda", length = 100)
    private String saleDescription;
}
