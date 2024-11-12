package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryDTO {
    private Integer id;
    private User user;
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
}
