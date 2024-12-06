package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String name;
    private Role role;
}
