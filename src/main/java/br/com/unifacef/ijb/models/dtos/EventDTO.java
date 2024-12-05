package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String date;
    private String state;
    private String code;
}
