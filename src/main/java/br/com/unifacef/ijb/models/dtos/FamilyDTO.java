package br.com.unifacef.ijb.models.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FamilyDTO {
    private Integer id;
    private BeneficiaryDTO beneficiary;
    private String familiarName;
    private String cpf;
    private String kinship;
    private Date birthDate;
    private String scholarity;
    private BigDecimal income;
    private String incomeDescription;
    private String healthyProblems;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
