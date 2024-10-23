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

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_movimentacoes")
public class Movement {
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
    private BigDecimal value;
    @Column(name = "dt_recebinento")
    private LocalDateTime receiptDate;
    @Column(name = "dt_vencimento")
    private LocalDateTime dueDate;
}
