package br.com.unifacef.ijb.models.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class VolunteerTypeDTO {
    private Integer id;
    private String volunteerNameType;

    public VolunteerTypeDTO(String volunteerNameType){
        this.volunteerNameType = volunteerNameType;
    }
}
