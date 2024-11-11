package br.com.unifacef.ijb.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.unifacef.ijb.models.dtos.VisitDTO;
import br.com.unifacef.ijb.models.entities.Visit;

public class VisitMapper {
    public static Visit convertVisitDTOIntoVisit(VisitDTO visitDTO){
        return new Visit(visitDTO.getId(), BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(visitDTO.getBeneficiaryDTO()), visitDTO.getVisitDate(),
        visitDTO.getReport(), visitDTO.getFirstImage(), visitDTO.getSecondImage(),
        visitDTO.getThirdImage(), visitDTO.getFourthImage(), visitDTO.getFifthImage());
    }

    public static VisitDTO convertVisitIntoVisitDTO(Visit visit){
        return new VisitDTO(visit.getId(), BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(visit.getBeneficiary()), visit.getVisitDate(),
        visit.getReport(), visit.getFirstImage(), visit.getSecondImage(),
        visit.getThirdImage(), visit.getFourthImage(), visit.getFifthImage());
    }

    public static List<VisitDTO> convertListVisitIntoListVisitDTO(List<Visit> visits){
        List<VisitDTO> visitDTOs = new ArrayList<>();

        for (Visit visit : visits) {
            visitDTOs.add(convertVisitIntoVisitDTO(visit));
        }
        return visitDTOs;
    }

    public static void updateVisit(VisitDTO visitDTO, Visit visit){
        visit.setBeneficiary(BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(visitDTO.getBeneficiaryDTO()));
        visit.setVisitDate(visitDTO.getVisitDate());
        visit.setReport(visitDTO.getReport());
        visit.setFirstImage(visitDTO.getFirstImage());
        visit.setSecondImage(visitDTO.getSecondImage());
        visit.setThirdImage(visitDTO.getThirdImage());
        visit.setFourthImage(visitDTO.getFourthImage());
        visit.setFifthImage(visitDTO.getFifthImage());
    }
}
