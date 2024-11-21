package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.MovementCreateDTO;
import br.com.unifacef.ijb.models.dtos.MovementDTO;
import br.com.unifacef.ijb.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class MovementController {
    @Autowired
    private MovementService movementService;

    @PostMapping
    public ResponseEntity<MovementDTO> createMovement(@RequestBody MovementCreateDTO movementDTO) {
        return ResponseEntity.ok(movementService.createMovement(movementDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementDTO> getMovementById(@PathVariable Integer id) {
        return ResponseEntity.ok(movementService.getMovementById(id));
    }

    @GetMapping
    public ResponseEntity<List<MovementDTO>> getAllMovements() {
        return ResponseEntity.ok(movementService.getAllMovements());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementDTO> updateMovement(@PathVariable Integer id, @RequestBody MovementCreateDTO movementDTO) {
        return ResponseEntity.ok(movementService.updateMovement(id, movementDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable Integer id) {
        movementService.deleteMovement(id);
        return ResponseEntity.noContent().build();
    }
}