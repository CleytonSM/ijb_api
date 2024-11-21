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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_tipos_movimentacoes")
@AllArgsConstructor
@NoArgsConstructor
public class MovementsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_movimentacao")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venda")
    private Sale sale;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_abatimento")
    private Rebate rebate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @Column(name = "nm_tipo_movimentacao", length = 25)
    private String movementTypeName;

    public MovementsType(Sale sale, Rebate rebate, Donation donation, String movementTypeName) {
    }
}
