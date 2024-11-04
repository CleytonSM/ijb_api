package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.VisitDTO;
import br.com.unifacef.ijb.models.entities.Visit;

public class VisitMapper {
    public static VisitDTO convertVisitDTOIntoVisit(VisitDTO visitDTO){
        return new VisitDTO(visitDTO.getId(), visitDTO.getBeneficiaryDTO(), visitDTO.getVisitDate());
    }

    public static Visit convertVisitIntoVisitDTO(Visit visit){
        return new Visit(visit.getId(), visit.getBeneficiary(), visit.getVisitDate());
    }
}
