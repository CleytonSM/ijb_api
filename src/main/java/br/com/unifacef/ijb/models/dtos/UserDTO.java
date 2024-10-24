package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;         
    private String email;        
    private String cpf;          
    private String password;     
}
