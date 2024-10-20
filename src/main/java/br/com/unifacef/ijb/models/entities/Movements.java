package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_movimentacoes")
public class Movements {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_movimentacao")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_movimentacao")
    private MovementsType movimentationType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_origem")
    private MovementsOrigin movementsOrigin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_situacao")
    private MovementsSituation movimentationSituation;
    @Column(name = "valor")
    private Float value;
    @Column(name = "dt_recebinento")
    private LocalDateTime receiptDate;
    @Column(name = "dt_vencimento")
    private LocalDateTime dueDate;
}
