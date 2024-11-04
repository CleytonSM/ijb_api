package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.VoluntaryVisitDTO;
import br.com.unifacef.ijb.models.entities.VoluntaryVisit;

public class VoluntaryVisitMapper {
    public static VoluntaryVisitDTO convertVoluntaryVisitDTOIntoVoluntaryVisit(VoluntaryVisitDTO voluntaryVisitDTO){
        return new VoluntaryVisitDTO(voluntaryVisitDTO.getId(), voluntaryVisitDTO.getVolunteerDTO());
    }

    public static VoluntaryVisit convertVoluntaryVisitIntoVoluntaryVisitDTO(VoluntaryVisit voluntaryVisit){
        return new VoluntaryVisit(voluntaryVisit.getId(), voluntaryVisit.getVolunteer());
    } 
}
