package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.UserInfoHelper;
import br.com.unifacef.ijb.mappers.UserInfoMapper;
import br.com.unifacef.ijb.mappers.UserMapper;
import br.com.unifacef.ijb.mappers.VolunteerMapper;
import br.com.unifacef.ijb.models.dtos.AuthorityDTO;
import br.com.unifacef.ijb.models.dtos.SupporterRegisterDTO;
import br.com.unifacef.ijb.models.dtos.UserCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserDTO;
import br.com.unifacef.ijb.models.dtos.UserInfoCreateDTO;
import br.com.unifacef.ijb.models.dtos.UserInfoDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerTypeDTO;
import br.com.unifacef.ijb.models.entities.Authority;
import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;
import br.com.unifacef.ijb.models.entities.UserInfo;
import br.com.unifacef.ijb.models.entities.Volunteer;
import br.com.unifacef.ijb.models.entities.VolunteerType;
import br.com.unifacef.ijb.models.enums.Role;
import br.com.unifacef.ijb.repositories.UserRepository;
import br.com.unifacef.ijb.repositories.VolunteerRepository;
import br.com.unifacef.ijb.repositories.VolunteerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerRepository repository;
    @Autowired
    private VolunteerTypeService volunteerTypeService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserInfoService userInfoService;

    public Volunteer save(Volunteer volunteer) {
        return repository.save(volunteer);
    }

    public VolunteerDTO createVolunteer(VolunteerRegisterDTO volunteerRegister, String volunteerType) {
        AuthorityDTO authorityDTO = authorityService.findAuthorityRole(Role.ROLE_VOLUNTARIO_BRONZE);
        UserInfoCreateDTO userInfoCreateDTO = UserInfoHelper.setUpUserInfoCreateDTO(authorityDTO, volunteerRegister);
        userInfoService.createUserInfo(userInfoCreateDTO);

        Volunteer volunteer = VolunteerMapper.convertVolunteerRegisterDTOIntoVolunteer(volunteerRegister);
        volunteer.setVolunteerType(volunteerTypeService.findByVolunteerNameType(volunteerType));

        return VolunteerMapper.convertVolunteerIntoVolunteerDTO(save(volunteer));
    }

    public List<VolunteerDTO> findAll() {
        List<Volunteer> volunteers = repository.findAll();
        return VolunteerMapper.convertVolunteersIntoVolunteerDTOs(volunteers);
    }

    public VolunteerDTO findById(Integer id) {
        Optional<Volunteer> optional = repository.findById(id);
        return optional.map(VolunteerMapper::convertVolunteerIntoVolunteerDTO).orElse(null);
    }

    public String remove(Integer id) {
        if (!repository.existsById(id)) {
            repository.deleteById(id);
            return "Cadastro não encontrado";
        }

        return "Cadastro removido com sucesso";
    }

    public String removeAll() {
        repository.deleteAll();
        return "Todos os cadastros foram removidos com sucesso";
    }

}
