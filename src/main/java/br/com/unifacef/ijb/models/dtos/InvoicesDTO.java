package br.com.unifacef.ijb.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoicesDTO {
    private Integer id;
    private MovementDTO movement;
    private byte[] invoicePhoto;

}