package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.enums.BeneficiaryStatus;
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
    private UserDTO user;
    private String name;
    private BeneficiaryStatus status;
    private String meetDescription;
    private String indicatorName;
    private String additionalInfo;
    private Boolean hasLand;
    private BigDecimal monthlyIncome;
    private LocalDateTime indicationDate;
    private String houseStatus;
    private String decisionTriage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
