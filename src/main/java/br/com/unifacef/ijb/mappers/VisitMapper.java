package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.VisitDTO;
import br.com.unifacef.ijb.models.entities.Visit;

public class VisitMapper {
    public static Visit convertVisitDTOIntoVisit(VisitDTO visitDTO){
        return new Visit();
    }

    public static VisitDTO convertVisitIntoVisitDTO(Visit visit){
        return new VisitDTO(visit.getId(), visit.getBeneficiary(), visit.getVisitDate());
    }
}
