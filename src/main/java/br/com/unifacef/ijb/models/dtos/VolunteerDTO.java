package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.models.entities.VolunteerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerDTO {
    private Integer id;
    private UserDTO user;
    private VolunteerTypeDTO volunteerType;
    private String desiredRole;
    private String aboutYou;
    private String hobby;
    private String intention;

    public VolunteerDTO(String desiredRole, String aboutYou, String hobby, String intention) {
        this.desiredRole = desiredRole;
        this.aboutYou = aboutYou;
        this.hobby = hobby;
        this.intention = intention;
    }
}
