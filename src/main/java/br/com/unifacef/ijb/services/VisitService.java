package br.com.unifacef.ijb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.VisitMapper;
import br.com.unifacef.ijb.models.dtos.VisitDTO;
import br.com.unifacef.ijb.models.entities.Visit;
import br.com.unifacef.ijb.repositories.VisitRepository;
import jakarta.transaction.Transactional;

@Service
public class VisitService {
    
    @Autowired
    VisitRepository repository;

    public Visit save(Visit visit){
        return repository.save(visit);
    }

    public Visit getById(Integer id){
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    // ----------------------------------------------------------------

    @Transactional
    public VisitDTO createVisit(VisitDTO visitDTO){
        Visit visit = VisitMapper.convertVisitDTOIntoVisit(visitDTO);

        return VisitMapper.convertVisitIntoVisitDTO(save(visit));
    }

    public List<VisitDTO> getAllVisits(){
        return VisitMapper.convertListVisitIntoListVisitDTO(repository.findAll());
    }

    public void getVisitsByBeneficiaryId(Integer id){
        List<VisitDTO> allVisitDTOs = getAllVisits();
        List<VisitDTO> visitDTOFiltered = new ArrayList<>();

        for(VisitDTO eachVisitDTO : allVisitDTOs){
            if(eachVisitDTO.getBeneficiaryDTO().getId().equals(id)){
                visitDTOFiltered.add(eachVisitDTO);
            }
        }
    }

    public void updateRetrievedVisit(VisitDTO visitDTO, Visit visit){
        VisitMapper.updateVisit(visitDTO, visit);
    }

    public VisitDTO updateVisit(VisitDTO visitDTO){
        Visit visit = getById(visitDTO.getId());
        updateRetrievedVisit(visitDTO, visit);
        
        return VisitMapper.convertVisitIntoVisitDTO(save(visit));
    }


}