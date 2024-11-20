package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.UserInfoDTO;
import br.com.unifacef.ijb.models.entities.UserInfo;

public class UserInfoMapper {
    public static UserInfoDTO converUserInfoIntoUserInfoDTO(UserInfo userInfo) {
        return new UserInfoDTO(UserMapper.convertUserIntoUserDTO(userInfo.getUser()),
                AuthorityMapper.convertAuthorityIntoAuthorityDTO(userInfo.getAuthority()),
                userInfo.getRegisteredAt(), userInfo.getActive(), userInfo.getRg(), userInfo.getProfilePic(),
                userInfo.getName(), userInfo.getLastName(), userInfo.getBirthdayDate(), userInfo.getPhone1(),
                userInfo.getPhone2(), userInfo.getCreatedAt(), userInfo.getUpdatedAt(), userInfo.getDeletedAt());
    }
}
