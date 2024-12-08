package br.com.unifacef.ijb.mappers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.unifacef.ijb.models.dtos.FamilyDTO;
import br.com.unifacef.ijb.models.entities.Family;

public class FamilyMapper {
    public static Family convertFamiliarDTOIntoFamiliar(FamilyDTO familyDTO){
        return new Family(familyDTO.getId(),
                BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(familyDTO.getBeneficiary()),
                familyDTO.getFamiliarName(),
                familyDTO.getCpf(),
                familyDTO.getKinship(),
                familyDTO.getScholarity(),
                familyDTO.getBirthDate(),
                familyDTO.getIncome(),
                familyDTO.getIncomeDescription(),
                familyDTO.getHealthyProblems(),
                familyDTO.getCreatedAt(),
                familyDTO.getUpdatedAt(),
                familyDTO.getDeletedAt());
    }

    public static FamilyDTO convertFamiliarIntoFamiliarDTO(Family family){
        return new FamilyDTO(family.getId(),
                BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(family.getBeneficiary()),
                family.getFamiliarName(),
                family.getCpf(),
                family.getKinship(),
                family.getBirthDate(),
                family.getScholarity(),
                family.getIncome(),
                family.getIncomeDescription(),
                family.getHealthyProblems(),
                family.getCreatedAt(),
                family.getUpdatedAt(),
                family.getDeletedAt());
    }

    //-----------------------------------

    public static List<FamilyDTO> convertListFamiliarIntoFamiliarDTO(List<Family> familys){
        List<FamilyDTO> familiarDTOs = new ArrayList<>();

        for (Family family : familys) {
            familiarDTOs.add(convertFamiliarIntoFamiliarDTO(family));
        }

        return familiarDTOs;
    }
    public static List<Family> converListFamiliarDTOIntoFamiliar(List<FamilyDTO> familyDTOs){
        List<Family> familiars = new ArrayList<>();

        for (FamilyDTO familyDTO : familyDTOs) {
            familiars.add(convertFamiliarDTOIntoFamiliar(familyDTO));
        }

        return familiars;
    }
    //-----------------------------------

    public static void updateFamily(FamilyDTO familiarDTO, Family familiar){
        familiar.setBeneficiary(BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(familiarDTO.getBeneficiary()));
        familiar.setFamiliarName(familiarDTO.getFamiliarName());
        familiar.setCpf(familiarDTO.getCpf());
        familiar.setKinship(familiarDTO.getKinship());
        familiar.setScholarity(familiarDTO.getScholarity());
        familiar.setBirthDate(familiarDTO.getBirthDate());
        familiar.setIncome(familiarDTO.getIncome());
        familiar.setIncomeDescription(familiarDTO.getIncomeDescription());
        familiar.setHealthyProblems(familiarDTO.getHealthyProblems());
        familiar.setUpdatedAt(LocalDateTime.now());
    }
}