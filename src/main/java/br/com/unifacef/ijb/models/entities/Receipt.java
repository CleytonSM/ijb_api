package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_receitas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_receita")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name = "id_abatimento")
    private Rebate rebate;
    @Column(name = "dt_recebimento")
    private LocalDateTime receiptDate;
    @Column(name = "dt_vencimento")
    private LocalDateTime expiryDate;
    @Column(name = "dt_criacao")
    private LocalDateTime createdAt;
    @Column(name = "dt_alteracao")
    private LocalDateTime updatedAt;
    @Column(name = "dt_exclusao")
    private LocalDateTime deletedAt;
}
