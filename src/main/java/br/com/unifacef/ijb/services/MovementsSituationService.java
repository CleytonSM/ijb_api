package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.MovementsSituationMapper;
import br.com.unifacef.ijb.models.dtos.MovementsSituationDTO;
import br.com.unifacef.ijb.models.entities.MovementsSituation;
import br.com.unifacef.ijb.repositories.MovementsSituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementsSituationService {
    @Autowired
    private MovementsSituationRepository movementsSituationRepository;

    public MovementsSituation save(MovementsSituation movementsSituation) {
        return movementsSituationRepository.save(movementsSituation);
    }

    public MovementsSituationDTO createMovementsSituation(MovementsSituationDTO movementsSituationDTO) {
        MovementsSituation movementsSituation = MovementsSituationMapper.convertMovementsSituationDTOToEntity(movementsSituationDTO);
        movementsSituation = save(movementsSituation);
        return MovementsSituationMapper.convertMovementsSituationEntityToDTO(movementsSituation);
    }

    public MovementsSituationDTO getMovementsSituationById(Integer id) {
        MovementsSituation movementsSituation = OptionalHelper.getOptionalEntity(movementsSituationRepository.findById(id));
        return MovementsSituationMapper.convertMovementsSituationEntityToDTO(movementsSituation);
    }

    public List<MovementsSituationDTO> getAllMovementsSituations() {
        return MovementsSituationMapper.convertListOfMovementsSituationToListOfDTOs(movementsSituationRepository.findAll());
    }

    public MovementsSituationDTO updateMovementsSituation(Integer id, MovementsSituationDTO movementsSituationDTO) {
        Optional<MovementsSituation> existingMovementsSituation = movementsSituationRepository.findById(id);
        if (!existingMovementsSituation.isPresent()) {
            return null;
        }

        MovementsSituation movementsSituationToUpdate = existingMovementsSituation.get();
        MovementsSituationMapper.updateMovementsSituationFromDTO(movementsSituationToUpdate, movementsSituationDTO);
        MovementsSituation updatedMovementsSituation = movementsSituationRepository.save(movementsSituationToUpdate);
        return MovementsSituationMapper.convertMovementsSituationEntityToDTO(updatedMovementsSituation);
    }


    public void deleteMovementsSituation(Integer id) {
        MovementsSituation movementsSituation = OptionalHelper.getOptionalEntity(movementsSituationRepository.findById(id));
        movementsSituationRepository.delete(movementsSituation);
    }
}
