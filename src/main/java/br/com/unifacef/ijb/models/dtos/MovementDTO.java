package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovementDTO {
    private Integer id;
    private MovementsTypeDTO movimentationType;
    private MovementsOriginDTO movementsOrigin;
    private MovementsSituationDTO movimentationSituation;
    private BigDecimal value;
    private LocalDateTime receiptDate;
    private LocalDateTime dueDate;

}