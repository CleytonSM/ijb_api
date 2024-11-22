package br.com.unifacef.ijb.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstructionDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private AddressDTO address;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String constructionStatus;
    private BigDecimal estimatedCost;
    private BigDecimal totalCost;

}
