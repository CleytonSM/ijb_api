package br.com.unifacef.ijb.helpers;

import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.entities.User;

public class UserHelperConverter {

    public static UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getPassword(),
                AuthorityHelperConverter.convertAuthorityToAuthorityDTO(user.getAuthority()));
    }

    public static User convertUserDTOToUser(UserDTO userDTO) {
        return new User(userDTO.getEmail(), userDTO.getPassword(),
                AuthorityHelperConverter.convertAuthorityDTOToAuthority(userDTO.getAuthority()));
    }
}
