package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.MovementsSituationDTO;
import br.com.unifacef.ijb.services.MovementsSituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements-situation")
public class MovementsSituationController {
    @Autowired
    private MovementsSituationService movementsSituationService;

    @PostMapping
    public ResponseEntity<MovementsSituationDTO> createMovementsSituation(@RequestBody MovementsSituationDTO movementsSituationDTO) {
        MovementsSituationDTO createdMovementsSituation = movementsSituationService.createMovementsSituation(movementsSituationDTO);
        return new ResponseEntity<>(createdMovementsSituation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementsSituationDTO> getMovementsSituationById(@PathVariable Integer id) {
        MovementsSituationDTO movementsSituation = movementsSituationService.getMovementsSituationById(id);
        if (movementsSituation != null) {
            return new ResponseEntity<>(movementsSituation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<MovementsSituationDTO>> getAllMovementsSituations() {
        List<MovementsSituationDTO> movementsSituations = movementsSituationService.getAllMovementsSituations();
        return new ResponseEntity<>(movementsSituations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementsSituationDTO> updateMovementsSituation(
            @PathVariable Integer id,
            @RequestBody MovementsSituationDTO movementsSituationDTO) {
        MovementsSituationDTO updatedMovementsSituation = movementsSituationService.updateMovementsSituation(id, movementsSituationDTO);
        if (updatedMovementsSituation != null) {
            return new ResponseEntity<>(updatedMovementsSituation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementsSituation(@PathVariable Integer id) {
        boolean isDeleted = movementsSituationService.deleteMovementsSituation(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
