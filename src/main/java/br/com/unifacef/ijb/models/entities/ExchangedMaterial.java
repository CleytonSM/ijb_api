package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.dtos.ExchangeCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "tb_materiais_trocados")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExchangedMaterial {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "id_material")
    private Material materials;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_troca")
    private Exchange exchange;


}
