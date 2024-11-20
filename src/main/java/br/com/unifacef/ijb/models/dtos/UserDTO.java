package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;         
    private String email;        
    private String cpf;          
    private String password;

    public UserDTO(Integer id, String email, String cpf) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
    }
}
