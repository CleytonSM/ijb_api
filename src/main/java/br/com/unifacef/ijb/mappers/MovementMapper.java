package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.MovementCreateDTO;
import br.com.unifacef.ijb.models.dtos.MovementDTO;
import br.com.unifacef.ijb.models.entities.Movement;

import java.util.ArrayList;
import java.util.List;

public class MovementMapper {
    public static Movement convertMovementDTOIntoMovement(MovementCreateDTO movementDTO) {
        return new Movement(
                ReceiptMapper.convertReceiptDTOIntoReceipt(movementDTO.getReceipt()),
                ExpenseMapper.convertExpenseDTOIntoExpense(movementDTO.getExpense())
        );
    }

    public static MovementDTO convertMovementIntoMovementDTO(Movement movement) {
        return new MovementDTO(
                movement.getId(),
                ReceiptMapper.convertReceiptIntoReceiptDTO(movement.getReceipt()),
                ExpenseMapper.convertExpenseIntoExpenseDTO(movement.getExpense())
        );
    }

    public static List<MovementDTO> convertListOfMovementIntoListOfMovementDTO(List<Movement> movements) {
        List<MovementDTO> movementDTOs = new ArrayList<>();
        for (Movement movement : movements) {
            movementDTOs.add(convertMovementIntoMovementDTO(movement));
        }
        return movementDTOs;
    }

    public static void updateMovement(MovementCreateDTO movementUpdate, Movement movement) {
        movement.setReceipt(ReceiptMapper.convertReceiptDTOIntoReceipt(movementUpdate.getReceipt()));
        movement.setExpense(ExpenseMapper.convertExpenseDTOIntoExpense(movementUpdate.getExpense()));
    }
}
