package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.Role;
import java.util.List;
import lombok.Data;

@Data
public class AuthorityDTO {
    private Integer id;                  
    private Role role;                  
    private String description;          
    private List<UserInfoDTO> userInfos; 
}
