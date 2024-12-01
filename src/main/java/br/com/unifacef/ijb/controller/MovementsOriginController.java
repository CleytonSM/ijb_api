package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.MovementsOriginDTO;
import br.com.unifacef.ijb.services.MovementsOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/movements-origin")
public class MovementsOriginController {
    @Autowired
    private MovementsOriginService movementsOriginService;

    @PostMapping
    public ResponseEntity<MovementsOriginDTO> createMovementsOrigin(@RequestBody MovementsOriginDTO movementsOriginDTO) {
        return new ResponseEntity<>(movementsOriginService.createMovementsOrigin(movementsOriginDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementsOriginDTO> getMovementsOriginById(@PathVariable Integer id) {
        return new ResponseEntity<>(movementsOriginService.getMovementsOriginById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovementsOriginDTO>> getAllMovementsOrigin() {
        return new ResponseEntity<>(movementsOriginService.getAllMovementsOrigins(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementsOriginDTO> updateMovementsOrigin(@PathVariable Integer id, @RequestBody MovementsOriginDTO movementsOriginDTO) {
        return new ResponseEntity<>(movementsOriginService.updateMovementsOrigin(id, movementsOriginDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementsOrigin(@PathVariable Integer id){
        movementsOriginService.deleteMovementsOrigin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}