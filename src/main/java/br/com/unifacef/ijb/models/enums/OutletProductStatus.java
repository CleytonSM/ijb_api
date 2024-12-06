package br.com.unifacef.ijb.models.enums;

import lombok.Getter;

@Getter
public enum OutletProductStatus {
    FOR_SALE("À venda"),
    EXCHANGED("Trocado"),
    REBATED("Abatido"),
    SOLD("Vendido");

    private final String value;

    OutletProductStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
