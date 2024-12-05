package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class TagsCreateDTO {
    private Integer id;
    private String labelName;
    private String colorHexadecimal;


}
