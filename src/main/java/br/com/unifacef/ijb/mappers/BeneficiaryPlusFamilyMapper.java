package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.models.dtos.BenficiaryWithFamilyDTO;
import br.com.unifacef.ijb.models.dtos.FamilyDTO;

import java.util.List;

public class BeneficiaryPlusFamilyMapper {
    public static BenficiaryWithFamilyDTO createBenefPlusFamil (BeneficiaryDTO beneficiaryDTO, List<FamilyDTO> familiars) {
        BenficiaryWithFamilyDTO result = new BenficiaryWithFamilyDTO();
        result.setBeneficiaryDTO(beneficiaryDTO);
        result.setFamiliarDTOList(familiars);
        return result;
    }
}
