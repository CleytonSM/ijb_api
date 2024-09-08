package br.com.unifacef.ijb.helper;

import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.entities.User;

public class UserConverter {

    public static UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getPassword(),
                AuthorityConverter.convertAuthorityToAuthorityDTO(user.getAuthority()));
    }

    public static User convertUserDTOToUser(UserDTO userDTO) {
        return new User(userDTO.getEmail(), userDTO.getPassword(),
                AuthorityConverter.convertAuthorityDTOToAuthority(userDTO.getAuthorityDTO()));
    }
}
