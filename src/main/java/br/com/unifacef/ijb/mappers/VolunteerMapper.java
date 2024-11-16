package br.com.unifacef.ijb.mappers;


import br.com.unifacef.ijb.models.dtos.VolunteerDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerTypeDTO;
import br.com.unifacef.ijb.models.entities.Volunteer;
import br.com.unifacef.ijb.models.entities.VolunteerType;

import java.util.ArrayList;
import java.util.List;

public class VolunteerMapper {

    public static Volunteer convertVolunteerDTOIntoVolunteer(VolunteerDTO pessoaDTO) {
        return new Volunteer(pessoaDTO.getDesiredRole(),
                pessoaDTO.getAboutYou(), pessoaDTO.getHobby(), pessoaDTO.getIntention());
    }

    public static VolunteerDTO convertVolunteerIntoVolunteerDTO(Volunteer pessoaEntity) {
        return new VolunteerDTO(pessoaEntity.getDesiredRole(),
                pessoaEntity.getAboutYou(), pessoaEntity.getHobby(), pessoaEntity.getIntention());
    }

    public static VolunteerType convertVolunteerTypeDTOIntoVolunteerType(VolunteerTypeDTO volunteerTypeDTO) {
        return new VolunteerType(volunteerTypeDTO.getVolunteerNameType());
    }

    public static VolunteerTypeDTO convertVolunteerTypeIntoVolunteerTypeDTO(VolunteerType volunteerType) {
        return new VolunteerTypeDTO(volunteerType.getVolunteerNameType());
    }

    public static List<VolunteerDTO> convertVolunteersIntoVolunteerDTOs(List<Volunteer> volunteers) {
        List<VolunteerDTO> volunteerDTOs = new ArrayList<>();
        for (Volunteer volunteer : volunteers) {
            volunteerDTOs.add(convertVolunteerIntoVolunteerDTO(volunteer));
        }
        return volunteerDTOs;
    }
}
