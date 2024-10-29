package br.com.unifacef.ijb.mapper;

import br.com.unifacef.ijb.models.dtos.VisitDTO;
import br.com.unifacef.ijb.models.entities.Visit;

public class VisitMapper {
    public static Visit convertVisitDTOIntoVisit(VisitDTO visitDTO){
        return new Visit(visitDTO.getId(), visitDTO.getBeneficiary(), visitDTO.getVisitDate());
    }

    public static VisitDTO convertVisitIntoVisitDTO(Visit visit){
        return new VisitDTO(visit.getId(), visit.getBeneficiary(), visit.getVisitDate());
    }
}