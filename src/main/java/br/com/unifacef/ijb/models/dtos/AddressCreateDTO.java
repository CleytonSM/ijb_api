package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class AddressCreateDTO {
    private String cep;
    private String street;
    private String number;
    private String neighborhood;
    private String complement;
}
