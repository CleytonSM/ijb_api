package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.entities.Beneficiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDTO {
    private Integer id;
    private Beneficiary beneficiary;
    private LocalDateTime visitDate;
}
