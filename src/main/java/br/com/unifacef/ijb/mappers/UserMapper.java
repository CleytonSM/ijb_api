package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.entities.User;

public class UserMapper {
    public static UserDTO convertUserIntoUserDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getCpf(), user.getPassword());
    }
}
