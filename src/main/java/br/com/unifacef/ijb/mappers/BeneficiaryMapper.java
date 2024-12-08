package br.com.unifacef.ijb.mappers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.models.entities.Beneficiary;

public class BeneficiaryMapper {
    public static Beneficiary convertBeneficiaryDTOIntoBeneficiary(BeneficiaryDTO beneficiaryDTO){
        return new Beneficiary(beneficiaryDTO.getId(),
        UserMapper.convertUserDTOIntoUser(beneficiaryDTO.getUser()),
        beneficiaryDTO.getName(), 
        beneficiaryDTO.getStatus(),
        beneficiaryDTO.getMeetDescription(), 
        beneficiaryDTO.getIndicatorName(), 
        beneficiaryDTO.getAdditionalInfo(), 
        beneficiaryDTO.getHasLand(),
        beneficiaryDTO.getMonthlyIncome(), 
        beneficiaryDTO.getIndicationDate(), 
        beneficiaryDTO.getHouseStatus(), 
        beneficiaryDTO.getDecisionTriage(),
        beneficiaryDTO.getCreatedAt(),
        beneficiaryDTO.getUpdatedAt(),
        beneficiaryDTO.getDeletedAt());
    }

    public static BeneficiaryDTO convertBeneficiaryIntoBeneficiaryDTO(Beneficiary beneficiary){
        return new BeneficiaryDTO(beneficiary.getId(),
        UserMapper.convertUserIntoUserDTO(beneficiary.getUser()),
        beneficiary.getName(), 
        beneficiary.getStatus(),
        beneficiary.getMeetDescription(),
        beneficiary.getIndicatorName(), 
        beneficiary.getAdditionalInfo(), 
        beneficiary.getHasLand(),
        beneficiary.getMonthlyIncome(), 
        beneficiary.getIndicationDate(), 
        beneficiary.getHouseStatus(), 
        beneficiary.getDecisionTriage(),
        beneficiary.getCreatedAt(),
        beneficiary.getUpdatedAt(),
        beneficiary.getUpdatedAt());
    }

    public static List<BeneficiaryDTO> convertListBeneficiaryIntoListBeneficiaryDTO(List<Beneficiary> beneficiaries){
        List<BeneficiaryDTO> beneficiaryDTOs = new ArrayList<>();
        
        for(Beneficiary beneficiary : beneficiaries){
            beneficiaryDTOs.add(convertBeneficiaryIntoBeneficiaryDTO(beneficiary));
        }
        return beneficiaryDTOs;
    }

    public static void updateBeneficiary(BeneficiaryDTO beneficiaryDTO, Beneficiary beneficiary){
        beneficiary.setName(beneficiaryDTO.getName());
        beneficiary.setStatus(beneficiaryDTO.getStatus());
        beneficiary.setMeetDescription(beneficiaryDTO.getMeetDescription());
        beneficiary.setIndicatorName(beneficiaryDTO.getIndicatorName());
        beneficiary.setAdditionalInfo(beneficiaryDTO.getAdditionalInfo());
        beneficiary.setHasLand(beneficiaryDTO.getHasLand());
        beneficiary.setMonthlyIncome(beneficiaryDTO.getMonthlyIncome());
        beneficiary.setIndicationDate(beneficiaryDTO.getIndicationDate());
        beneficiary.setHouseStatus(beneficiaryDTO.getHouseStatus());
        beneficiary.setDecisionTriage(beneficiaryDTO.getDecisionTriage());
        beneficiary.setUpdatedAt(LocalDateTime.now());
    }
}