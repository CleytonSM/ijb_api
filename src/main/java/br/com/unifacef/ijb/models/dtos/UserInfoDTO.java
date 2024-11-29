package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.entities.Authority;
import br.com.unifacef.ijb.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private UserDTO user;
    private AuthorityDTO authority;
    private LocalDateTime registeredAt;
    private Boolean active;
    private String rg;
    private byte[] profilePic;
    private String name;
    private String lastName;
    private LocalDateTime birthdayDate;
    private String phone1;
    private String phone2;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
