package br.com.unifacef.ijb.models.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class InvoicesDTO {
    private Integer id;
    private String taxCode;
    private String cnpjSupplier;
    private Float value;
    private LocalDateTime dueDate;

}