package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ConstructionCreateDTO {
    private AddressCreateDTO address;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String constructionStatus;
    private BigDecimal estimatedCost;
    private BigDecimal totalCost;

}
