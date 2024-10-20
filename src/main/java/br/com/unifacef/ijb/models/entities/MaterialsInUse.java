package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_materiais_em_uso")
@Entity
public class MaterialsInUse {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_material_em_uso")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_material")
    private Materials materials;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_construcao")
    private Constructions constructions;
}
