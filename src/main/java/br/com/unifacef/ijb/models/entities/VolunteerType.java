package br.com.unifacef.ijb.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_tipos_voluntarios")
@Data
public class VolunteerType {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_voluntario(PK)")
    private Integer id;
    @Column(name = "nm_tipo_voluntario")
    private String volunteerNameType;

    public VolunteerType(){}
    public VolunteerType(String volunteerNameType){
        this.volunteerNameType = volunteerNameType;
    }
}
