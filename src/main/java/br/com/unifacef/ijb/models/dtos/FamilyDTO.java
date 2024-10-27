package br.com.unifacef.ijb.models.dtos;

import java.math.BigDecimal;

import br.com.unifacef.ijb.models.entities.Beneficiary;
import lombok.Data;

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
