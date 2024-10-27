package br.com.unifacef.ijb.models.dtos;

import java.time.LocalDateTime;

import br.com.unifacef.ijb.models.entities.Beneficiary;
import lombok.Data;

@Data
public class VisitDTO {
    private Integer id;
    private Beneficiary beneficiary;
    private LocalDateTime visitDate;
}
