package br.com.unifacef.ijb.models.idClasses;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ExchangedMaterialId {
    private Integer material;
    private Integer exchange;
}
