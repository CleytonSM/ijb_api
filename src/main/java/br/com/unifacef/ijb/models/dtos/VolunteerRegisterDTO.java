package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerRegisterDTO {
    private String name;
    private String lastName;
    private String phone1;
    private String email;
    private String hobby;
    private String cpf;
    private String intention;
    private String desiredRole;
    private String aboutYou;
}
