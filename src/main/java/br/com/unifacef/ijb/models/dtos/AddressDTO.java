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

    public AddressDTO(Integer id, String cep, String street, String number, String neighborhood, String complement) {
        this.id = id;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.complement = complement;
    }
}
