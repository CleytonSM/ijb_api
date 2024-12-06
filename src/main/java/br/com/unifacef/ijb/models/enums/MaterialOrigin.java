package br.com.unifacef.ijb.models.enums;

public enum MaterialOrigin {
    BOUGHT("Compra"),
    DONATED("Doação");

    public final String value;

    MaterialOrigin(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
