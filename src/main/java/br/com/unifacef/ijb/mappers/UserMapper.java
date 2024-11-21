package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;
import br.com.unifacef.ijb.models.entities.User;

public class UserMapper {
    public static UserDTO convertUserIntoUserDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getCpf(), user.getPassword());
    }

    public static User convertUserCreateDTOToUser(UserCreateDTO userCreateDTO) {
        return new User(userCreateDTO.getEmail(), userCreateDTO.getCpf(), userCreateDTO.getPassword());
    }

    public static UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getCpf());
    }

    public static UserCreateDTO convertVolunteerRegisterDTOIntoUserCreateDTO(VolunteerRegisterDTO volunteerRegister) {
        return new UserCreateDTO(volunteerRegister.getEmail(),
                volunteerRegister.getCpf(), volunteerRegister.getPassword());
    }
}
