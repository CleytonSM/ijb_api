package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_trocas")
public class Exchanges {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_troca")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_prod_outlet")
    private OutletProducts outletProducts;
    @Column(name = "ds_troca", length = 100)
    private String ExchangesDescription;

}
