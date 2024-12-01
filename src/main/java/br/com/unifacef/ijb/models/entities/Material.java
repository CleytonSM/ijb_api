package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.enums.MaterialOrigin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "tb_materiais")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Integer id;
    @Column(name = "nm_material")
    private String name;
    @Column(name = "quantidade")
    private Integer quantity;
    @Column(name = "ds_material")
    private String description;
    @Column(name = "preco")
    private BigDecimal price;
    @Column(name = "origem")
    @Enumerated(EnumType.STRING)
    private MaterialOrigin origin;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;

    public Material(String name, Integer quantity, String description, BigDecimal price, MaterialOrigin origin,
                    LocalDateTime createdAt) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.origin = origin;
        this.createdAt = createdAt;
    }
}
