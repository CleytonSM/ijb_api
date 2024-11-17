package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenficiaryPlusFamiliarsDTO {
    BeneficiaryDTO beneficiaryDTO;
    List<FamiliarDTO> familiarDTOList;
}
