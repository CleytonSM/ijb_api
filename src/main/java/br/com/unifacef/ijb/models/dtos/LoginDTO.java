package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class LoginDTO {
    private String emailOrCpf;
    private String password;
}
