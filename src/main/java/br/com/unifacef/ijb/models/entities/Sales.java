package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_vendas")
public class Sales {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_prod_outlet")
    private OutletProducts outletProducts;
    @Column(name = "valor_venda")
    private Float SaleValue;
    @Column(name = "ds_venda", length = 100)
    private String saleDescription;
}
