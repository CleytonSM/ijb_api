package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.MovementsOriginDTO;
import br.com.unifacef.ijb.models.entities.MovementsOrigin;

import java.util.ArrayList;
import java.util.List;

public class MovementsOriginMapper {
    public static MovementsOrigin convertMovementsOriginDTOIntoMovement(MovementsOriginDTO dto) {
        return new MovementsOrigin(
                dto.getOriginName()
        );
    }

    public static MovementsOriginDTO convertMovementsOriginEntityIntoMovementDTO(MovementsOrigin entity) {
        return new MovementsOriginDTO(
                entity.getId(),
                entity.getOriginName()
        );
    }

    public static List<MovementsOriginDTO> convertListOfMovementsOriginIntoListOfMovementsOriginDTO(List<MovementsOrigin> movements) {
        List<MovementsOriginDTO> movementsOriginDTOS = new ArrayList<>();
        for (MovementsOrigin movementsOrigin : movements) {
            movementsOriginDTOS.add(convertMovementsOriginEntityIntoMovementDTO(movementsOrigin));
        }
        return movementsOriginDTOS;
    }

    public static void updateMovementsOrigin(MovementsOrigin movementsOrigin, MovementsOriginDTO movementsOriginDTO) {
        movementsOrigin.setOriginName(movementsOriginDTO.getOriginName());
    }
}
