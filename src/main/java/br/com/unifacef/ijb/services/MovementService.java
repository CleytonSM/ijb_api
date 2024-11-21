package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.mappers.MovementMapper;
import br.com.unifacef.ijb.models.dtos.MovementCreateDTO;
import br.com.unifacef.ijb.models.dtos.MovementDTO;
import br.com.unifacef.ijb.models.entities.Movement;
import br.com.unifacef.ijb.repositories.MovementRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {
    @Autowired
    private MovementRepository movementRepository;

    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }

    @Transactional
    public MovementDTO createMovement(MovementCreateDTO movementDTO) {
        Movement movement = MovementMapper.convertMovementDTOIntoMovement(movementDTO);
        movement = save(movement);
        return MovementMapper.convertMovementIntoMovementDTO(movement);
    }

    public List<MovementDTO> getAllMovements() {
        return MovementMapper.convertListOfMovementIntoListOfMovementDTO(movementRepository.findAll());
    }

    public MovementDTO getMovementById(Integer id) {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movement not found with id " + id));
        return MovementMapper.convertMovementIntoMovementDTO(movement);
    }

    @Transactional
    public MovementDTO updateMovement(Integer id, MovementCreateDTO movementDTO) {
        Movement existingMovement = movementRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Movement not found with id: " + id));
        MovementMapper.updateMovement(movementDTO, existingMovement);
        Movement updatedMovement = movementRepository.save(existingMovement);

        return MovementMapper.convertMovementIntoMovementDTO(updatedMovement);
    }

    @Transactional
    public void deleteMovement(Integer id) {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movement not found with id " + id));
        movementRepository.delete(movement);
    }
}
