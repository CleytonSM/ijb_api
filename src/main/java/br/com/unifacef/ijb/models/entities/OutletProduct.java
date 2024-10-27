package br.com.unifacef.ijb.models.entities;

import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import org.hibernate.annotations.Filter;

@Data
@Entity
@Table(name = "tb_produtos_outlet")
@AllArgsConstructor
@NoArgsConstructor
@Filter(name = "statusFilter", condition = "status != INACTIVE")
public class OutletProduct {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_prod_outlet")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doacao")
    private Donation donation;
    @Column(name = "nm_prod_outlet", length = 60)
    private String outletProductName;
    @Column(name = "ds_prod_outlet", length = 100)
    private String outletProductDescription;
    @Column(name = "status", length = 20)
    @Enumerated(EnumType.STRING)
    private OutletProductStatus status;

    public OutletProduct(Donation donation, String outletProductName, String outletProductDescription,
                         OutletProductStatus status) {
        this.donation = donation;
        this.outletProductName = outletProductName;
        this.outletProductDescription = outletProductDescription;
        this.status = status;
    }
}
