package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.mappers.VolunteerMapper;
import br.com.unifacef.ijb.models.dtos.VolunteerDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerTypeDTO;
import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.models.entities.Volunteer;
import br.com.unifacef.ijb.models.entities.VolunteerType;
import br.com.unifacef.ijb.repositories.UserRepository;
import br.com.unifacef.ijb.repositories.VolunteerRepository;
import br.com.unifacef.ijb.repositories.VolunteerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    private VolunteerTypeRepository volunteerTypeRepository;

    @Autowired
    private UserRepository userRepository;

    public VolunteerDTO insere(VolunteerDTO pessoaDTO) {
        VolunteerType volunteerType = volunteerTypeRepository
                .findByVolunteerNameType(String.valueOf(pessoaDTO.getVolunteerType()))
                .orElseGet(() -> volunteerTypeRepository.save(new VolunteerType(String.valueOf(pessoaDTO.getVolunteerType()))));

        Optional<User> optionalUser = userRepository.findByEmail(pessoaDTO.getUser().getEmail());

        User user = optionalUser.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Volunteer volunteer = VolunteerMapper.convertVolunteerDTOIntoVolunteer(pessoaDTO);

        volunteer.setVolunteerType(volunteerType);
        volunteer.setUser(user);

        Volunteer volunteerEntity = volunteerRepository.save(volunteer);
        return VolunteerMapper.convertVolunteerIntoVolunteerDTO(volunteerEntity);
    }


    public List<VolunteerDTO> consultaTodos() {
        List<Volunteer> volunteers = volunteerRepository.findAll();
        return VolunteerMapper.convertVolunteersIntoVolunteerDTOs(volunteers);
    }

    public VolunteerDTO consultaPorId(Long id) {
        Optional<Volunteer> optional = volunteerRepository.findById(id);
        return optional.map(VolunteerMapper::convertVolunteerIntoVolunteerDTO).orElse(null);
    }

    public String remove(Long id) {
        if (volunteerRepository.existsById(id)) {
            volunteerRepository.deleteById(id);
            return "Cadastro removido com sucesso";
        } else {
            return "Cadastro não encontrado";
        }
    }

    public String removeAll() {
        volunteerRepository.deleteAll();
        return "Todos os cadastros foram removidos com sucesso";
    }

    public VolunteerType converteDtoParaEntity(VolunteerTypeDTO volunteerTypeDTO) {
        return VolunteerMapper.convertVolunteerTypeDTOIntoVolunteerType(volunteerTypeDTO);
    }

    public VolunteerTypeDTO converteEntityParaDto(VolunteerType volunteerType) {
        return VolunteerMapper.convertVolunteerTypeIntoVolunteerTypeDTO(volunteerType);
    }
}
