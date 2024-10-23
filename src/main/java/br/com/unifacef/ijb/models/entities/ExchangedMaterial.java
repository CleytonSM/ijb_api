package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "tb_materiais_trocados")
@Entity
public class ExchangedMaterial {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_material")
    private List<Material> materials;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_troca")
    private List<Exchange> exchange;
}
