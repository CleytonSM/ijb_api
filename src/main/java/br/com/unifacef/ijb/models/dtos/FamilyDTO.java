package br.com.unifacef.ijb.models.dtos;

import java.math.BigDecimal;

import br.com.unifacef.ijb.models.entities.Beneficiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FamilyDTO {
    private Integer id;
    private Beneficiary beneficiary;
    private String familyName;
    private String kinship;
    private String scholarity;
    private BigDecimal income;
    private String incomeDescription;
    private String healthyProblems;
}
