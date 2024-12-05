package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.models.dtos.BenficiaryPlusFamiliarsDTO;
import br.com.unifacef.ijb.models.dtos.FamiliarDTO;

import java.util.List;

public class BeneficiaryPlusFamiliarsMapper {
    public static BenficiaryPlusFamiliarsDTO createBenefPlusFamil (BeneficiaryDTO beneficiaryDTO, List<FamiliarDTO> familiars) {
        BenficiaryPlusFamiliarsDTO result = new BenficiaryPlusFamiliarsDTO();
        result.setBeneficiaryDTO(beneficiaryDTO);
        result.setFamiliarDTOList(familiars);

        return result;
    }
}
