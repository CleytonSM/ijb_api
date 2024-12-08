package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.BeneficiaryRegisterDTO;
import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;
import br.com.unifacef.ijb.models.entities.User;

import java.time.LocalDateTime;

public class UserMapper {
    public static UserDTO convertUserIntoUserDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getCpf(), user.getPassword(), user.getCreatedAt(),
                user.getUpdatedAt(), user.getDeletedAt());
    }
    public static User convertUserDTOIntoUser(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getEmail(), userDTO.getCpf(), userDTO.getPassword(), userDTO.getCreatedAt(),
                userDTO.getUpdatedAt(), userDTO.getDeletedAt());
    }

    public static User convertUserCreateDTOToUser(UserCreateDTO userCreateDTO) {
        return new User(userCreateDTO.getEmail(), userCreateDTO.getCpf(), userCreateDTO.getPassword(), LocalDateTime.now());
    }

    public static UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getCpf());
    }

    public static UserCreateDTO convertVolunteerRegisterDTOIntoUserCreateDTO(VolunteerRegisterDTO volunteerRegister) {
        return new UserCreateDTO(volunteerRegister.getEmail(),
                volunteerRegister.getCpf(), volunteerRegister.getPassword());
    }

    public static UserCreateDTO convertBeneficiaryRegisterDTOIntoUserCreateDTO(
            BeneficiaryRegisterDTO beneficiaryRegister) {
        return new UserCreateDTO(beneficiaryRegister.getEmail(), beneficiaryRegister.getCpf(),
                beneficiaryRegister.getPassword());
    }
}
