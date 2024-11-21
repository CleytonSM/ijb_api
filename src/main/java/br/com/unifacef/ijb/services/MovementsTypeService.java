package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.mappers.MovementsTypeMapper;
import br.com.unifacef.ijb.models.dtos.MovementsTypeCreateDTO;
import br.com.unifacef.ijb.models.dtos.MovementsTypeDTO;
import br.com.unifacef.ijb.models.entities.MovementsType;
import br.com.unifacef.ijb.repositories.MovementsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementsTypeService {
    @Autowired
    private MovementsTypeRepository movementsTypeRepository;

    public MovementsTypeDTO createMovementsType(MovementsTypeCreateDTO movementsTypeCreateDTO) {
        MovementsType movementsType = MovementsTypeMapper.convertMovementsTypeCreateDTOToEntity(movementsTypeCreateDTO);
        MovementsType savedMovementsType = movementsTypeRepository.save(movementsType);
        return MovementsTypeMapper.convertMovementsTypeEntityToDTO(savedMovementsType);
    }

    public MovementsTypeDTO updateMovementsType(Integer id, MovementsTypeCreateDTO movementsTypeDTO) {
        Optional<MovementsType> existingMovementsType = movementsTypeRepository.findById(id);
        if (existingMovementsType.isPresent()) {
            MovementsType movementsType = existingMovementsType.get();
            MovementsTypeMapper.updateMovementsTypeFromDTO(movementsType, movementsTypeDTO);
            MovementsType updatedMovementsType = movementsTypeRepository.save(movementsType);
            return MovementsTypeMapper.convertMovementsTypeEntityToDTO(updatedMovementsType);
        }
        return null;
    }

    public List<MovementsTypeDTO> getAllMovementsTypes() {
        List<MovementsType> movementsTypes = movementsTypeRepository.findAll();
        return MovementsTypeMapper.convertListOfMovementsTypeToListOfDTOs(movementsTypes);
    }

    public MovementsTypeDTO getMovementsTypeById(Integer id) {
        Optional<MovementsType> movementsType = movementsTypeRepository.findById(id);
        return movementsType.map(MovementsTypeMapper::convertMovementsTypeEntityToDTO).orElse(null);
    }

    public boolean deleteMovementsType(Integer id) {
        if (movementsTypeRepository.existsById(id)) {
            movementsTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
