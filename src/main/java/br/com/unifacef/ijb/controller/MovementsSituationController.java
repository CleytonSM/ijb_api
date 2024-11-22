package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.MovementsSituationDTO;
import br.com.unifacef.ijb.services.MovementsSituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/movements-situation")
public class MovementsSituationController {
    @Autowired
    private MovementsSituationService movementsSituationService;

    @PostMapping
    public ResponseEntity<MovementsSituationDTO> createMovementsSituation(@RequestBody MovementsSituationDTO movementsSituationDTO) {
       return new ResponseEntity<>(movementsSituationService.createMovementsSituation(movementsSituationDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementsSituationDTO> getMovementsSituationById(@PathVariable Integer id) {
        return new ResponseEntity<>(movementsSituationService.getMovementsSituationById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovementsSituationDTO>> getAllMovementsSituations() {
        return new ResponseEntity<>(movementsSituationService.getAllMovementsSituations(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementsSituationDTO> updateMovementsSituation(@PathVariable Integer id, @RequestBody MovementsSituationDTO movementsSituationDTO) {
        return new ResponseEntity<>(movementsSituationService.updateMovementsSituation(id, movementsSituationDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementsSituation(@PathVariable Integer id) {
       movementsSituationService.deleteMovementsSituation(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
}