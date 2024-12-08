package br.com.unifacef.ijb.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.FamilyMapper;
import br.com.unifacef.ijb.models.dtos.FamilyDTO;
import br.com.unifacef.ijb.models.entities.Family;
import br.com.unifacef.ijb.repositories.FamilyRepository;
import jakarta.transaction.Transactional;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository repository;

    public Family save(Family familiar) {
        return repository.save(familiar);
    }

    public Family getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    //------------------------------------------
    @Transactional
    public FamilyDTO createFamily(FamilyDTO familiarDTO) {
        Family familiar = FamilyMapper.convertFamiliarDTOIntoFamiliar(familiarDTO);

        return FamilyMapper.convertFamiliarIntoFamiliarDTO(save(familiar));
    }

    public List<FamilyDTO> getAllFamiliars(){
        return FamilyMapper.convertListFamiliarIntoFamiliarDTO(repository.findAll());
    }

    public List<FamilyDTO> getAllFamiliarsByBeneficiaryID(Integer id){
        List<FamilyDTO> allFamiliarDTOs = getAllFamiliars();
        List<FamilyDTO> familiarDTOFiltered = new ArrayList<>();

        for (FamilyDTO eachFamiliarDTO : allFamiliarDTOs) {
            if(eachFamiliarDTO.getBeneficiary().getId().equals(id)) {
                familiarDTOFiltered.add(eachFamiliarDTO);
            }
        }

        return familiarDTOFiltered;
    }

    public void updateRetrievedFamiliar(FamilyDTO familiarDTO, Family familiar){
        FamilyMapper.updateFamily(familiarDTO, familiar);
    }
    public void updateFamily(FamilyDTO familiarDTO){
        Family family = getById( familiarDTO.getId());
        updateRetrievedFamiliar(familiarDTO, family);

        save(family);
    }

    public void deleteFamiliar (Integer id){
        repository.deleteById(id);
        Family family = getById(id);
        family.setDeletedAt(LocalDateTime.now());
    }
}
