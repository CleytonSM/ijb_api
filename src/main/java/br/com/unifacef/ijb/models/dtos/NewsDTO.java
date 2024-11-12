package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class NewsDTO {
    private Integer id;
    private TagsDTO tags;
    //falta o id do voluntario
    private String newsImg;
    private Date publicationDate;
    private Boolean visibilityStatus;
    private String newsAuthor;
    private String newsURL;
    private String newsDescription;
}
