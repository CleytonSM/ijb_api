package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryCreateDTO {
    private UserCreateDTO user;
    private AuthorityDTO authorityDTO;
    private String name;
    private String status;
    private String meetDescription;
    private String indicatorName;
    private String additionalInfo;
    private Boolean hasLand;
    private BigDecimal monthlyIncome;
    private LocalDateTime indicationDate;
    private String houseStatus;
    private String decisionTriage;


    public BeneficiaryCreateDTO(UserCreateDTO userCreateDTO, AuthorityDTO authorityDTO, String name) {
        this.user = userCreateDTO;
        this.authorityDTO = authorityDTO;
        this.name = name;
    }
}
