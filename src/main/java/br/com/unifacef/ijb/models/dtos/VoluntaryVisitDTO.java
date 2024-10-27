package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.entities.Volunteer;
import lombok.Data;

@Data
public class VoluntaryVisitDTO {
    private Integer id;
    private Volunteer volunteer;
}
