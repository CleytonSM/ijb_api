package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.models.dtos.BeneficiaryInfoDTO;
import br.com.unifacef.ijb.models.dtos.UserInfoDTO;

public class BeneficiaryInfoMapper {
    public static BeneficiaryInfoDTO createBeneficiaryInfoDTO(BeneficiaryDTO beneficiaryDTO, UserInfoDTO userInfoDTO) {
        BeneficiaryInfoDTO beneficiaryInfoDTO = new BeneficiaryInfoDTO();
        beneficiaryInfoDTO.setBeneficiary(beneficiaryDTO);
        beneficiaryInfoDTO.setUserInfo(userInfoDTO);
        return beneficiaryInfoDTO;
    }
}
