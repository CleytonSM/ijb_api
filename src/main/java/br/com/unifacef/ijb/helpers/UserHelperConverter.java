package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.entities.User;

public class UserHelperConverter {

    public static UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getEmail());
    }

    public static User convertUserCreateDTOToUser(UserCreateDTO userCreateDTO) {
        return new User(userCreateDTO.getEmail(), userCreateDTO.getPassword(),
                AuthorityHelperConverter.convertAuthorityCreateDTOToAuthority(userCreateDTO.getAuthority()));
    }
}
