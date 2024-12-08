package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.entities.Beneficiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDTO {
    private Integer id;
    private BeneficiaryDTO beneficiary;
    private LocalDateTime visitDate;
    private String visitReport;
    private byte[] photo1;
    private byte[] photo2;
    private byte[] photo3;
    private byte[] photo4;
    private byte[] photo5;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private  LocalDateTime deleteAt;
}
