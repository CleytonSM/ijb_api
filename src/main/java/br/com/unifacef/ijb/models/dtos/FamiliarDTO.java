package br.com.unifacef.ijb.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FamiliarDTO {
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