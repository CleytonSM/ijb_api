package br.com.unifacef.ijb.mapper;

import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.models.entities.Beneficiary;

public class BeneficiaryMapper {
    public static Beneficiary convertBeneficiaryDTOIntoBeneficiary(BeneficiaryDTO beneficiaryDTO){
        return new Beneficiary(beneficiaryDTO.getId(), beneficiaryDTO.getUser(), beneficiaryDTO.getName(), beneficiaryDTO.getStatus(),
        beneficiaryDTO.getMeetDescription(),beneficiaryDTO.getIndicatorName(), beneficiaryDTO.getIndicationDate(),
        beneficiaryDTO.getMonthlyIncome(), beneficiaryDTO.getIndicationDate(), beneficiaryDTO.getHouseStatus());
    }

    public static BeneficiaryDTO convertBeneficiaryIntoBeneficiaryDTO(Beneficiary beneficiary){
        return new BeneficiaryDTO(beneficiary.getId(), beneficiary.getUser(), beneficiary.getName(), beneficiary.getStatus(),
                beneficiary.getMeetDescription(), beneficiary.getIndicatorName(), beneficiary.getIndicationDate(),
                beneficiary.getMonthlyIncome(), beneficiary.getIndicationDate(), beneficiary.getHouseStatus());
    }
}
