package br.com.unifacef.ijb.models.enums;

public enum Role {
    ROLE_BENEFICIARIO("ROLE_BENEFICIARIO"),
    ROLE_VOLUNTARIO("ROLE_VOLUNTARIO"),
    ROLE_FINANCEIRO("ROLE_FINANCEIRO"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String type;

    Role(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
