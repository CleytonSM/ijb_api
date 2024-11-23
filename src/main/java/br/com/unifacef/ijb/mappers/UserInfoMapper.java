package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.dtos.BeneficiaryRegisterDTO;
import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.dtos.UserInfoCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserInfoDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;
import br.com.unifacef.ijb.models.entities.Authority;
import br.com.unifacef.ijb.models.entities.UserInfo;

import java.time.LocalDateTime;

public class UserInfoMapper {
    public static UserInfoDTO convertUserInfoIntoUserInfoDTO(UserInfo userInfo) {
        return new UserInfoDTO(UserMapper.convertUserIntoUserDTO(userInfo.getUser()),
                AuthorityMapper.convertAuthorityIntoAuthorityDTO(userInfo.getAuthority()),
                userInfo.getRegisteredAt(), userInfo.getActive(), userInfo.getRg(), userInfo.getProfilePic(),
                userInfo.getName(), userInfo.getLastName(), userInfo.getBirthdayDate(), userInfo.getPhone1(),
                userInfo.getPhone2(), userInfo.getCreatedAt(), userInfo.getUpdatedAt(), userInfo.getDeletedAt());
    }

    public static UserInfo convertUserInfoCreateDTOIntoUserInfo(UserInfoCreateDTO userInfoCreate) {
        return new UserInfo(UserMapper.convertUserCreateDTOToUser(userInfoCreate.getUser()),
                AuthorityMapper.convertAuthorityDTOIntoAuthority(userInfoCreate.getAuthority()),
                userInfoCreate.getRegisteredAt(), userInfoCreate.getRg(), userInfoCreate.getProfilePic(),
                userInfoCreate.getName(), userInfoCreate.getLastName(), userInfoCreate.getBirthdayDate(),
                userInfoCreate.getPhone1(), userInfoCreate.getCreatedAt(), userInfoCreate.getUpdatedAt(),
                userInfoCreate.getPhone2(), userInfoCreate.getDeletedAt());
    }

    public static UserInfoCreateDTO setUpUserInfoCreateDTOBasedOnUserCreateDTOAndAuthorityDTOAndVolunteerRegisterDTO
            (UserCreateDTO userCreateDTO, AuthorityDTO authorityDTO, VolunteerRegisterDTO volunteerRegister){
        return new UserInfoCreateDTO(userCreateDTO, authorityDTO, LocalDateTime.now(), volunteerRegister.getName(),
                volunteerRegister.getLastName(), volunteerRegister.getPhone1(), LocalDateTime.now(),
                LocalDateTime.now());
    }

    public static UserInfoCreateDTO setUpUserInfoCreateDTOBasedOnUserCreateDToAndAuthorityDTOAndBeneficiaryRegisterDTO
            (UserCreateDTO userCreateDTO, AuthorityDTO authorityDTO, BeneficiaryRegisterDTO beneficiaryRegister) {
        return new UserInfoCreateDTO(userCreateDTO, authorityDTO, LocalDateTime.now(), beneficiaryRegister.getName(),
                beneficiaryRegister.getLastName(), beneficiaryRegister.getPhone1(), beneficiaryRegister.getPhone2(),
                LocalDateTime.now(), LocalDateTime.now());
    }
}
