package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenficiaryWithFamilyDTO {
    BeneficiaryDTO beneficiaryDTO;
    List<FamilyDTO> familiarDTOList;
}
