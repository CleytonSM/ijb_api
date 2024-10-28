package br.com.unifacef.ijb.mapper;

import br.com.unifacef.ijb.models.dtos.FamilyDTO;
import br.com.unifacef.ijb.models.entities.Family;

public class FamilyMapper {
    public static Family convertFamilyDTOIntoFamily(FamilyDTO familyDTO){
        return new Family(familyDTO.getId(), familyDTO.getBeneficiary(),familyDTO.getFamilyName(),
        familyDTO.getKinship(), familyDTO.getScholarity(), familyDTO.getIncome(), familyDTO.getIncomeDescription(),
        familyDTO.getHealthyProblems());
    }

    public static FamilyDTO convertFamilyIntoFamilyDTO(Family family){
        return new FamilyDTO(family.getId(), family.getBeneficiary(), family.getFamilyName(),
        family.getKinship(), family.getScholarity(), family.getIncome(), family.getIncomeDescription(),
        family.getHealthyProblems());
    }
}
