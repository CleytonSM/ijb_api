package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.mappers.UserInfoMapper;
import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.dtos.BeneficiaryRegisterDTO;
import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserInfoCreateDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;

public class UserInfoHelper {

    public static UserInfoCreateDTO setUpUserInfoCreateDTO(AuthorityDTO authorityDTO,
                                                           VolunteerRegisterDTO volunteerRegister) {
        UserCreateDTO userCreateDTO = UserHelper.setUpUserCreateDTO(volunteerRegister);
        return UserInfoMapper.setUpUserInfoCreateDTOBasedOnUserCreateDTOAndAuthorityDTOAndVolunteerRegisterDTO(
                userCreateDTO, authorityDTO, volunteerRegister);
    }

    public static UserInfoCreateDTO setUpUserInfoCreateDTO(AuthorityDTO authorityDTO, BeneficiaryRegisterDTO beneficiaryRegister) {
        UserCreateDTO userCreateDTO = UserHelper.setUpUserCreateDTO(beneficiaryRegister);
        return UserInfoMapper.setUpUserInfoCreateDTOBasedOnUserCreateDToAndAuthorityDTOAndBeneficiaryRegisterDTO(
                userCreateDTO, authorityDTO, beneficiaryRegister);
    }
}
