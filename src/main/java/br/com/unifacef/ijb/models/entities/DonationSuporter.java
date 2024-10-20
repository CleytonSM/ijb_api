package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_doacoes_apoiadores")
public class DonationSuporter {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_apoiador")
    private Supporter supporter;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_doacao")
    private Donations donation;
}
