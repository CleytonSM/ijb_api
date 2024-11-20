package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.UserInfoMapper;
import br.com.unifacef.ijb.models.dtos.UserInfoDTO;
import br.com.unifacef.ijb.models.entities.UserInfo;
import br.com.unifacef.ijb.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoService {
    @Autowired
    private UserInfoRepository repository;
    @Autowired
    private UserService userService;

    public UserInfoDTO getUserInfoDTOByEmail(String email) {
        UserInfo userInfo = getUserInfoByEmail(email);

        return UserInfoMapper.converUserInfoIntoUserInfoDTO(userInfo);
    }


    public UserInfo getUserInfoByEmail(String email) {
        return OptionalHelper.getOptionalEntity(repository.findByUserEmail(email));
    }
}
