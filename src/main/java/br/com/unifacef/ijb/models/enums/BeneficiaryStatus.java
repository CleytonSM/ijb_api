package br.com.unifacef.ijb.models.enums;

import lombok.Getter;

@Getter
public enum BeneficiaryStatus {
    ACTIVE("ativo"),
    INACTIVE("inativo");


    private final String status;

    BeneficiaryStatus(String status) {
        this.status = status;
    }

}
