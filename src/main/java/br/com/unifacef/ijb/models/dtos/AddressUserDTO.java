package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class AddressUserDTO {
    private AddressDTO addressDTO;
    private UserDTO userDTO;
}
