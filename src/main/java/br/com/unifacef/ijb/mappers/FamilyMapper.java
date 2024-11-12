package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.FamilyDTO;
import br.com.unifacef.ijb.models.entities.Family;

public class FamilyMapper {
    public static Family convertFamilyDTOIntoFamily(FamilyDTO familyDTO){
        return new Family();
    }

    public static FamilyDTO convertFamilyIntoFamilyDTO(Family family){
        return new FamilyDTO(family.getId(), family.getBeneficiary(), family.getFamiliarName(), family.getCpf(), family.getKinship(),
        family.getBirthDate(), family.getScholarity(), family.getIncome(), family.getIncomeDescription(), family.getHealthyProblems());
    }
}
