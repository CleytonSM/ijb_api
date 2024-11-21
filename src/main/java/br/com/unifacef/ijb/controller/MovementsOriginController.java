package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.MovementsOriginDTO;
import br.com.unifacef.ijb.services.MovementsOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements-origin")
public class MovementsOriginController {
    @Autowired
    private MovementsOriginService movementsOriginService;

    @PostMapping
    public ResponseEntity<MovementsOriginDTO> createMovementsOrigin(@RequestBody MovementsOriginDTO movementsOriginDTO) {
        return ResponseEntity.ok(movementsOriginService.createMovementsOrigin(movementsOriginDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementsOriginDTO> getMovementsOriginById(@PathVariable Integer id) {
        return ResponseEntity.ok(movementsOriginService.getMovementsOriginById(id));
    }

    @GetMapping
    public ResponseEntity<List<MovementsOriginDTO>> getAllMovementsOrigin() {
        return ResponseEntity.ok(movementsOriginService.getAllMovementsOrigins());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementsOriginDTO> updateMovementsOrigin(@PathVariable Integer id, @RequestBody MovementsOriginDTO movementsOriginDTO) {
        return ResponseEntity.ok(movementsOriginService.updateMovementsOrigin(id, movementsOriginDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementsOrigin(@PathVariable Integer id){
        movementsOriginService.deleteMovementsOrigin(id);
        return ResponseEntity.noContent().build();
    }
}
