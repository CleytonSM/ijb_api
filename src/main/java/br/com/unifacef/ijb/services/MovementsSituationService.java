package br.com.unifacef.ijb.services;

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

    public MovementsSituationDTO createMovementsSituation(MovementsSituationDTO movementsSituationDTO) {
        MovementsSituation movementsSituation = MovementsSituationMapper.convertMovementsSituationDTOToEntity(movementsSituationDTO);
        MovementsSituation savedMovementsSituation = movementsSituationRepository.save(movementsSituation);
        return MovementsSituationMapper.convertMovementsSituationEntityToDTO(savedMovementsSituation);
    }

    public MovementsSituationDTO getMovementsSituationById(Integer id) {
        Optional<MovementsSituation> movementsSituation = movementsSituationRepository.findById(id);
        return movementsSituation.map(MovementsSituationMapper::convertMovementsSituationEntityToDTO).orElse(null);
    }

    public List<MovementsSituationDTO> getAllMovementsSituations() {
        List<MovementsSituation> movementsSituations = movementsSituationRepository.findAll();
        return MovementsSituationMapper.convertListOfMovementsSituationToListOfDTOs(movementsSituations);
    }

    public MovementsSituationDTO updateMovementsSituation(Integer id, MovementsSituationDTO movementsSituationDTO) {
        Optional<MovementsSituation> existingMovementsSituation = movementsSituationRepository.findById(id);
        if (existingMovementsSituation.isPresent()) {
            MovementsSituation movementsSituationToUpdate = existingMovementsSituation.get();
            MovementsSituationMapper.updateMovementsSituationFromDTO(movementsSituationToUpdate, movementsSituationDTO);
            MovementsSituation updatedMovementsSituation = movementsSituationRepository.save(movementsSituationToUpdate);
            return MovementsSituationMapper.convertMovementsSituationEntityToDTO(updatedMovementsSituation);
        }
        return null;
    }

    public boolean deleteMovementsSituation(Integer id) {
        if (movementsSituationRepository.existsById(id)) {
            movementsSituationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
