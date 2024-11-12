package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoDTO {
    private Integer userId;           
    private Integer authorityId;       
    private LocalDateTime createdAt;   
    private Boolean active;            
    private String rg;                
    private byte[] profilePic;        
    private String name;               
    private String lastName;           
    private LocalDateTime birthdayDate;
    private String phone1;             
    private String phone2;             
}
