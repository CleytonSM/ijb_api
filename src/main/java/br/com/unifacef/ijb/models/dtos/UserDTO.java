package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;          // ID do usuário
    private String email;        // Email do usuário
    private String cpf;          // CPF do usuário
    private String password;     // Senha do usuário
}
