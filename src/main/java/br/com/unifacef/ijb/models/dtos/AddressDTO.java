package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer id;
    private String cep;
    private String street;
    private String number;
    private String neighborhood;
    private String complement;
}
