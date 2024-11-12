package br.com.unifacef.ijb.models.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDTO {
    private Integer id;
    private BeneficiaryDTO beneficiaryDTO;
    private LocalDateTime visitDate;
    private String report;
    private byte[] firstImage;
    private byte[] secondImage;
    private byte[] thirdImage;
    private byte[] fourthImage;
    private byte[] fifthImage;
}
