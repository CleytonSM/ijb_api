package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.dtos.BeneficiaryCreateDTO;
import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.models.dtos.BeneficiaryRegisterDTO;
import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.entities.Beneficiary;

public class BeneficiaryMapper {
    public static Beneficiary convertBeneficiaryDTOIntoBeneficiary(BeneficiaryDTO beneficiaryDTO){
        return new Beneficiary();
    }

    public static BeneficiaryDTO convertBeneficiaryIntoBeneficiaryDTO(Beneficiary beneficiary){
        return new BeneficiaryDTO(beneficiary.getId(), beneficiary.getUser(), beneficiary.getName(),
                beneficiary.getStatus(), beneficiary.getMeetDescription(), beneficiary.getIndicatorName(),
                beneficiary.getAdditionalInfo(), beneficiary.getHasLand(), beneficiary.getMonthlyIncome(),
                beneficiary.getIndicationDate(), beneficiary.getHouseStatus(), beneficiary.getDecisionTriage());
    }

}
