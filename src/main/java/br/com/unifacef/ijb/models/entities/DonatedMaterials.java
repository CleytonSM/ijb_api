package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_materiais_doados")
@Entity
public class DonatedMaterials {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_material_doado")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_material")
    private Materials materials;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donations donations;
    @Column(name = "nm_material", length = 60)
    private String materialName;
    @Column(name = "qnt_material")
    private String materialQuantity;
}
