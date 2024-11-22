package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryRegisterDTO {
    private String email;
    private String cpf;
    private String password;
    private String name;
    private String lastName;
    private LocalDateTime birthdayDate;
    private String phone1;
    private String phone2;
}
