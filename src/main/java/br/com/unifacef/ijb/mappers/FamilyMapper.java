package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.FamilyDTO;
import br.com.unifacef.ijb.models.entities.Family;

public class FamilyMapper {
    public static Family convertFamilyDTOIntoFamily(FamilyDTO familyDTO){
        return new Family(familyDTO.getId(), familyDTO.getBeneficiary(), familyDTO.getFamiliarName(), familyDTO.getCpf(),
        familyDTO.getKinship(), familyDTO.getScholarity(),familyDTO.getBirthDate(), familyDTO.getIncome(), familyDTO.getIncomeDescription(),
        familyDTO.getHealthyProblems());
    }

    public static FamilyDTO convertFamilyIntoFamilyDTO(Family family){
        return new FamilyDTO(family.getId(), family.getBeneficiary(), family.getFamiliarName(), family.getCpf(), family.getKinship(),
        family.getBirthDate(), family.getScholarity(), family.getIncome(), family.getIncomeDescription(), family.getHealthyProblems());
    }
}
