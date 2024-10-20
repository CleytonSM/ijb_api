package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_produtos_outlet")
public class OutletProducts {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_prod_outlet")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donations donation;
    @Column(name = "nm_prod_outlet", length = 60)
    private String OutletProductName;
    @Column(name = "ds_prod_outlet", length = 100)
    private String OutletProductDescription;
    @Column(name = "status", length = 20)
    private String Status;
}
