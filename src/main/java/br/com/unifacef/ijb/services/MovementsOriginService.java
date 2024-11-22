package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.MovementsOriginMapper;
import br.com.unifacef.ijb.models.dtos.MovementsOriginDTO;
import br.com.unifacef.ijb.models.entities.MovementsOrigin;
import br.com.unifacef.ijb.repositories.MovementsOriginRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementsOriginService {
    @Autowired
    private MovementsOriginRepository movementsOriginRepository;

    public MovementsOrigin save(MovementsOrigin movementsOrigin) {
        return movementsOriginRepository.save(movementsOrigin);
    }

    @Transactional
    public MovementsOriginDTO createMovementsOrigin(MovementsOriginDTO movementsOriginDTO) {
        MovementsOrigin movementsOrigin = MovementsOriginMapper.convertMovementsOriginDTOIntoMovement(movementsOriginDTO);
        movementsOrigin = save(movementsOrigin);
        return MovementsOriginMapper.convertMovementsOriginEntityIntoMovementDTO(movementsOrigin);
    }

    public List<MovementsOriginDTO> getAllMovementsOrigins() {
        return MovementsOriginMapper.convertListOfMovementsOriginIntoListOfMovementsOriginDTO(movementsOriginRepository.findAll());
    }

    public MovementsOriginDTO getMovementsOriginById(Integer id) {
        MovementsOrigin movementsOrigin = OptionalHelper.getOptionalEntity(movementsOriginRepository.findById(id));
        return MovementsOriginMapper.convertMovementsOriginEntityIntoMovementDTO(movementsOrigin);
    }

    public MovementsOriginDTO updateMovementsOrigin(Integer id, MovementsOriginDTO movementsOriginDTO) {
        Optional<MovementsOrigin> existingMovementsOrigin = movementsOriginRepository.findById(id);
        if (!existingMovementsOrigin.isPresent()) {
            return null;
        }

        MovementsOrigin movementsOriginToUpdate = existingMovementsOrigin.get();
        MovementsOriginMapper.updateMovementsOrigin(movementsOriginToUpdate, movementsOriginDTO);
        MovementsOrigin updatedMovementsOrigin = movementsOriginRepository.save(movementsOriginToUpdate);
        return MovementsOriginMapper.convertMovementsOriginEntityIntoMovementDTO(updatedMovementsOrigin);
    }

    public void deleteMovementsOrigin(Integer id) {
        MovementsOrigin movementsOrigin = OptionalHelper.getOptionalEntity(movementsOriginRepository.findById(id));
        movementsOriginRepository.delete(movementsOrigin);
    }
}
