package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.FamiliarDTO;
import br.com.unifacef.ijb.models.entities.Familiar;

public class FamiliarMapper {
    public static Familiar convertFamiliarDTOIntoFamiliar(FamiliarDTO family){
        return new Familiar(family.getId(),
        BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(family.getBeneficiaryDTO()), 
        family.getFamiliarName(),
        family.getCpf(),
        family.getKinship(), 
        family.getScholarity(),
        family.getBirthDate(), 
        family.getIncome(), 
        family.getIncomeDescription(), 
        family.getHealthyProblems());
    }

    public static FamiliarDTO convertFamiliarIntoFamiliarDTO(Familiar familyDTO){
        return new FamiliarDTO(familyDTO.getId(),
        BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(familyDTO.getBeneficiary()),
        familyDTO.getFamiliarName(),
        familyDTO.getCpf(),
        familyDTO.getKinship(), 
        familyDTO.getScholarity(), 
        familyDTO.getBirthDate(), 
        familyDTO.getIncome(),
        familyDTO.getIncomeDescription(),
        familyDTO.getHealthyProblems());
    }
}
