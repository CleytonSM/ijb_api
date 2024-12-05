package br.com.unifacef.ijb.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.unifacef.ijb.models.dtos.FamiliarDTO;
import br.com.unifacef.ijb.models.entities.Familiar;

public class FamiliarMapper {
    public static Familiar convertFamiliarDTOIntoFamiliar(FamiliarDTO familyDTO){
        return new Familiar(familyDTO.getId(),
        BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(familyDTO.getBeneficiaryDTO()), 
        familyDTO.getFamiliarName(),
        familyDTO.getCpf(),
        familyDTO.getKinship(), 
        familyDTO.getScholarity(),
        familyDTO.getBirthDate(), 
        familyDTO.getIncome(), 
        familyDTO.getIncomeDescription(), 
        familyDTO.getHealthyProblems());
    }

    public static FamiliarDTO convertFamiliarIntoFamiliarDTO(Familiar family){
        return new FamiliarDTO(family.getId(),
        BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(family.getBeneficiary()),
        family.getFamiliarName(),
        family.getCpf(),
        family.getKinship(), 
        family.getScholarity(), 
        family.getBirthDate(), 
        family.getIncome(),
        family.getIncomeDescription(),
        family.getHealthyProblems());
    }

    //-----------------------------------

    public static List<FamiliarDTO> converListFamiliarIntoFamiliarDTO(List<Familiar> familiars){
        List<FamiliarDTO> familiarDTOs = new ArrayList<>();

        for (Familiar familiar : familiars) {
            familiarDTOs.add(convertFamiliarIntoFamiliarDTO(familiar));
        }
        
        return familiarDTOs;
    }
    public static List<Familiar> converListFamiliarDTOIntoFamiliar(List<FamiliarDTO> familiarDTOs){
        List<Familiar> familiars = new ArrayList<>();

        for (FamiliarDTO familiarDTO : familiarDTOs) {
            familiars.add(convertFamiliarDTOIntoFamiliar(familiarDTO));
        }

        return familiars;
    }
    //-----------------------------------

    public static void updateFamiliar(FamiliarDTO familiarDTO, Familiar familiar){
        familiar.setBeneficiary(BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(familiarDTO.getBeneficiaryDTO()));
        familiar.setFamiliarName(familiarDTO.getFamiliarName());
        familiar.setCpf(familiarDTO.getCpf());
        familiar.setKinship(familiarDTO.getKinship());
        familiar.setScholarity(familiarDTO.getScholarity());
        familiar.setBirthDate(familiarDTO.getBirthDate());
        familiar.setIncome(familiarDTO.getIncome());
        familiar.setIncomeDescription(familiarDTO.getIncomeDescription());
        familiar.setHealthyProblems(familiarDTO.getHealthyProblems());
    }
}