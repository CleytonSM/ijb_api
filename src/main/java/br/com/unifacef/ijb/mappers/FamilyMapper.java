package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.FamilyDTO;
import br.com.unifacef.ijb.models.entities.Family;

public class FamilyMapper {
    public static FamilyDTO convertFamilyDTOIntoFamily(FamilyDTO familyDTO){
        return new FamilyDTO(familyDTO.getId(), familyDTO.getBeneficiaryDTO(), familyDTO.getFamiliarName(), familyDTO.getCpf(),
        familyDTO.getKinship(), familyDTO.getScholarity(),familyDTO.getBirthDate(), familyDTO.getIncome(), familyDTO.getIncomeDescription(),
        familyDTO.getHealthyProblems());
    }

    public static Family convertFamilyIntoFamilyDTO(Family family){
        return new Family(family.getId(), family.getBeneficiary(), family.getFamiliarName(), family.getCpf(),
        family.getKinship(), family.getScholarity(), family.getBirthDate(), family.getIncome(), family.getIncomeDescription(),
        family.getHealthyProblems());
    }
}
