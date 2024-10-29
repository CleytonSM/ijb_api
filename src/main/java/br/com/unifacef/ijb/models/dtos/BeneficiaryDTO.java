package br.com.unifacef.ijb.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.unifacef.ijb.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private BigDecimal monthlyIncome;
    private LocalDateTime indicationDate;
    private String houseStatus;
}