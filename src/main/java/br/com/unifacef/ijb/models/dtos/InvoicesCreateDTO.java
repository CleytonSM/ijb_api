package br.com.unifacef.ijb.models.dtos;

import lombok.Data;

@Data
public class InvoicesCreateDTO {
    private MovementCreateDTO movement;
    private byte[] invoicePhoto;
}
