package br.com.unifacef.ijb.models.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_tipos_movimentacoes")
public class MovementsType {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_movimentacao")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venda")
    private Sales sales;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_abatimento")
    private Rebate rebate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donations donation;
    @Column(name = "nm_tipo_movimentacao", length = 25)
    private String movementTypeName;
}
