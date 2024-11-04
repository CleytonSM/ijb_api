package br.com.unifacef.ijb.models.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FamilyDTO {
    private Integer id;
    private BeneficiaryDTO beneficiaryDTO;
    private String familiarName;
    private String cpf;
    private String kinship;
    private String scholarity;
    private Date birthDate;
    private BigDecimal income;
    private String incomeDescription;
    private String healthyProblems;
}
