package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "tb_materiais_comprados")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PurchasedMaterial {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_material_doado")
    private Integer id;
    @Column(name = "nm_material", length = 60)
    private String materialName;
    @Column(name = "qnt_material")
    private Integer materialQuantity;

    public PurchasedMaterial(String materialName, Integer materialQuantity) {
        this.materialName = materialName;
        this.materialQuantity = materialQuantity;
    }

}
