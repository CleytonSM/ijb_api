package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_materiais_comprados")
@Entity
public class PurchadeMaterials {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_material_doado")
    private Integer id;
    @Column(name = "nm_material", length = 60)
    private String materialName;
    @Column(name = "qnt_material")
    private Integer materialQuantity;

}
