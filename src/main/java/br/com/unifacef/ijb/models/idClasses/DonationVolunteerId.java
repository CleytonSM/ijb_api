package br.com.unifacef.ijb.models.idClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationVolunteerId {
    private Integer volunteer;
    private Integer donation;
}