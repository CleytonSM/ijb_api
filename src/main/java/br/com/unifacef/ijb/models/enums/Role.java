package br.com.unifacef.ijb.models.enums;

import java.util.stream.Stream;

public enum Role {
    ROLE_BENEFICIARIO("ROLE_BENEFICIARIO"),
    ROLE_VOLUNTARIO_BRONZE("ROLE_VOLUNTARIO_BRONZE"),
    ROLE_VOLUNTARIO_PRATA("ROLE_VOLUNTARIO_PRATA"),
    ROLE_VOLUNTARIO_OURO("ROLE_VOLUNTARIO_OURO"),
    ROLE_FINANCEIRO("ROLE_FINANCEIRO"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String type;

    Role(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Role findRole(String outboundRole) {
        return Stream.of(Role.values())
                .filter(role -> role.getType().equals(outboundRole))
                .findFirst().orElse(null);
    }
}
