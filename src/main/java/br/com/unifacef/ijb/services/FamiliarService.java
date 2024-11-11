package br.com.unifacef.ijb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.FamiliarMapper;
import br.com.unifacef.ijb.models.dtos.FamiliarDTO;
import br.com.unifacef.ijb.models.entities.Familiar;
import br.com.unifacef.ijb.repositories.FamiliarRepository;
import jakarta.transaction.Transactional;

@Service
public class FamiliarService {
    
    @Autowired
    private FamiliarRepository repository;

    public Familiar save(Familiar familiar) {
        return repository.save(familiar);
    }

    public Familiar getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    //------------------------------------------
    @Transactional
    public FamiliarDTO createFamiliar(FamiliarDTO familiarDTO) {
        Familiar familiar = FamiliarMapper.convertFamiliarDTOIntoFamiliar(familiarDTO);

        return FamiliarMapper.convertFamiliarIntoFamiliarDTO(save(familiar));
    }

    public List<FamiliarDTO> getAllFamiliars(){
        return FamiliarMapper.converListFamiliarIntoFamiliarDTO(repository.findAll());
    }

    public List<FamiliarDTO> getAllFamiliarsByBeneficiaryID(Integer id){
        List<FamiliarDTO> allFamiliarDTOs = getAllFamiliars();
        List<FamiliarDTO> familiarDTOFiltered = new ArrayList<>();

        for (FamiliarDTO eachFamiliarDTO : allFamiliarDTOs) {
            if(eachFamiliarDTO.getBeneficiaryDTO().getId().equals(id)) {
                familiarDTOFiltered.add(eachFamiliarDTO);
            }
        }

        return familiarDTOFiltered;
    }

    public void updateRetrievedFamiliar(FamiliarDTO familiarDTO, Familiar familiar){
        FamiliarMapper.updateFamiliar(familiarDTO, familiar);
    }
    public FamiliarDTO updateFamiliar(FamiliarDTO familiarDTO){
        Familiar familiar = getById( familiarDTO.getId());
        updateRetrievedFamiliar(familiarDTO, familiar);

        return FamiliarMapper.convertFamiliarIntoFamiliarDTO(save(familiar));
    }
}
