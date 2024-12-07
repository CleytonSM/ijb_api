package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddressCreateDTO {
    private String cep;
    private String street;
    private String number;
    private String neighborhood;
    private String complement;

}
