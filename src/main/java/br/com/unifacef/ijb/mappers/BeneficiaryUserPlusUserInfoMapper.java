package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.dtos.UserInfoDTO;
import br.com.unifacef.ijb.models.dtos.UserPlusUserInfoDTO;

public class BeneficiaryUserPlusUserInfoMapper {
    public static UserPlusUserInfoDTO createUserPlusUserInfoDTO(UserDTO userDTO, UserInfoDTO userInfoDTO) {
        UserPlusUserInfoDTO result = new UserPlusUserInfoDTO();
        result.setUser(userDTO);
        result.setUserInfo(userInfoDTO);

        return result;
    }
}
