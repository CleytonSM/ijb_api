package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_materiais")
@Entity
public class Material {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_material")
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_material_doado")
    private DonatedMaterial donatedMaterial;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_material_comprado")
    private PurchasedMaterial purchasedMaterial;
}
