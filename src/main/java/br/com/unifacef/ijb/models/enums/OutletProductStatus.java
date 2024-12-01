package br.com.unifacef.ijb.models.enums;

import lombok.Getter;

@Getter
public enum OutletProductStatus {
    ACTIVE("ATIVO"),
    EXCHANGED("TROCADO"),
    REBATED("ABATIDO"),
    SOLD("VENDIDO");

    private final String status;

    OutletProductStatus(String status) {
        this.status = status;
    }
}
