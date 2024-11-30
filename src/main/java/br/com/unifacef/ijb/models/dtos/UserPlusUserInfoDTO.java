package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPlusUserInfoDTO {
    UserDTO user;
    UserInfoDTO userInfo;
}
