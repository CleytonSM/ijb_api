package br.com.unifacef.ijb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.FamiliarMapper;
import br.com.unifacef.ijb.models.dtos.FamiliarDTO;
import br.com.unifacef.ijb.models.entities.Familiar;
import br.com.unifacef.ijb.repositories.FamiliarRepository;
import jakarta.transaction.Transactional;

@Service
public class FamilyService {
    
    @Autowired
    private FamiliarRepository repository;

    public Familiar save(Familiar familiar) {
        return repository.save(familiar);
    }

    public Familiar findById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    //------------------------------------------
    @Transactional
    public FamiliarDTO createFamiliar(FamiliarDTO familiarDTO) {
        Familiar familiar = FamiliarMapper.convertFamilyDTOIntoFamily(familiarDTO);

        return FamiliarMapper.convertFamilyIntoFamilyDTO(save(familiar));
    }
    
}
