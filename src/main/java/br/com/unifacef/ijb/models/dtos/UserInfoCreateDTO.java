package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoCreateDTO {
    private UserCreateDTO user;
    private AuthorityDTO authority;
    private LocalDateTime registeredAt;
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

    public UserInfoCreateDTO(UserCreateDTO user, AuthorityDTO authority, LocalDateTime registeredAt, String name,
                             String lastName, String phone1, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.user = user;
        this.authority = authority;
        this.registeredAt = registeredAt;
        this.name = name;
        this.lastName = lastName;
        this.phone1 = phone1;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserInfoCreateDTO(UserCreateDTO user, AuthorityDTO authority, LocalDateTime registeredAt, String name, String lastName, String phone1, String phone2, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.user = user;
        this.registeredAt = registeredAt;
        this.authority = authority;
        this.name = name;
        this.lastName = lastName;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
