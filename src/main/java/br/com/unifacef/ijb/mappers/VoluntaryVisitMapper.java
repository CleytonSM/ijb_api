package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.VoluntaryVisitDTO;
import br.com.unifacef.ijb.models.entities.VoluntaryVisit;

public class VoluntaryVisitMapper {
    public static VoluntaryVisit convertVoluntaryVisitDTOIntoVoluntaryVisit(VoluntaryVisitDTO voluntaryVisitDTO){
        return new VoluntaryVisit();
    } 
}