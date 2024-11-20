package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConstructionDTO {
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String constructionStatus;
}
