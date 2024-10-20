package br.com.unifacef.ijb.models.entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_voluntarios_apoiadores")
@Entity
public class VolunteerSupporters {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_voluntario_apoidador")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_apoiador")
    private Supporter supporter;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_voluntario")
    private Volunteer volunteer;
    @Column(name = "sobre_voce", length = 240)
    private String about;
    @Column(name = "hobby", length = 60)
    private String hobby;
    @Column(name = "intencao", length = 60)
    private String intention;

}
