package br.com.unifacef.ijb.models.idClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SponsorEventId {
    private Integer sponsor;
    private Integer event;
}