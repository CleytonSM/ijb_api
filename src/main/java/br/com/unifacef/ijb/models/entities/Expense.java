package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_despesas")
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_despesa")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_material_comprado")
    private PurchasedMaterial purchasedMaterial;
    @ManyToOne
    @JoinColumn(name = "id_obra")
    private Construction construction;
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
