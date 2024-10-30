package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangedMaterialDTO {
    private MaterialDTO material;
    private ExchangeDTO exchange;

    public ExchangedMaterialDTO(List<MaterialDTO> materialDTOs, List<ExchangeDTO> exchangeDTOs) {
    }


}
