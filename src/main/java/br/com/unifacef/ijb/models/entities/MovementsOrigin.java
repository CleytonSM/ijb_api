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
@Entity
@Table(name = "tb_origem_movimentacoes")
@AllArgsConstructor
@NoArgsConstructor
public class MovementsOrigin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_origem")
    private Integer id;
    @Column(name = "nm_origem", length = 25)
    private String originName;

    public MovementsOrigin(String originName) {
    }
}
