package br.com.unifacef.ijb.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.unifacef.ijb.models.dtos.VisitDTO;
import br.com.unifacef.ijb.models.entities.Visit;

public class VisitMapper {
    public static Visit convertVisitDTOIntoVisit(VisitDTO visitDTO){
        return new Visit(visitDTO.getId(),
                BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(visitDTO.getBeneficiary()),
                visitDTO.getVisitDate(),
                visitDTO.getVisitReport(),
                visitDTO.getPhoto1(),
                visitDTO.getPhoto2(),
                visitDTO.getPhoto3(),
                visitDTO.getPhoto4(),
                visitDTO.getPhoto5(),
                visitDTO.getCreateAt(),
                visitDTO.getUpdateAt(),
                visitDTO.getDeleteAt());
    }

    public static VisitDTO convertVisitIntoVisitDTO(Visit visit){
        return new VisitDTO(visit.getId(),
                BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(visit.getBeneficiary()),
                visit.getVisitDate(),
                visit.getVisitReport(),
                visit.getPhoto1(),
                visit.getPhoto2(),
                visit.getPhoto3(),
                visit.getPhoto4(),
                visit.getPhoto5(),
                visit.getCreatedAt(),
                visit.getUpdatedAt(),
                visit.getDeletedAt());
    }

    public static List<VisitDTO> convertListVisitIntoListVisitDTO(List<Visit> visits){
        List<VisitDTO> visitDTOs = new ArrayList<>();

        for (Visit visit : visits) {
            visitDTOs.add(convertVisitIntoVisitDTO(visit));
        }
        return visitDTOs;
    }

    public static void updateVisit(VisitDTO visitDTO, Visit visit){
        visit.setBeneficiary(BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(visitDTO.getBeneficiary()));
        visit.setVisitDate(visitDTO.getVisitDate());
        visit.setVisitReport(visitDTO.getVisitReport());
        visit.setPhoto1(visitDTO.getPhoto1());
        visit.setPhoto2(visitDTO.getPhoto2());
        visit.setPhoto3(visitDTO.getPhoto3());
        visit.setPhoto4(visitDTO.getPhoto4());
        visit.setPhoto5(visitDTO.getPhoto5());
    }
}
