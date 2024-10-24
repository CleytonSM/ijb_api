package br.com.unifacef.ijb.models.dtos;

import java.time.LocalDateTime;
import lombok.Data;

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
