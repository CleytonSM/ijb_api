package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.MovementsTypeCreateDTO;
import br.com.unifacef.ijb.models.dtos.MovementsTypeDTO;
import br.com.unifacef.ijb.services.MovementsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements-type")
public class MovementsTypeController {
    @Autowired
    private MovementsTypeService movementsTypeService;

    @PostMapping
    public ResponseEntity<MovementsTypeDTO> createMovementsType(@RequestBody MovementsTypeCreateDTO movementsTypeCreateDTO) {
        MovementsTypeDTO createdMovementsType = movementsTypeService.createMovementsType(movementsTypeCreateDTO);
        return new ResponseEntity<>(createdMovementsType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementsTypeDTO> updateMovementsType(@PathVariable Integer id, @RequestBody MovementsTypeCreateDTO movementsTypeDTO) {
        MovementsTypeDTO updatedMovementsType = movementsTypeService.updateMovementsType(id, movementsTypeDTO);
        return updatedMovementsType != null ? new ResponseEntity<>(updatedMovementsType, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<MovementsTypeDTO>> getAllMovementsTypes() {
        List<MovementsTypeDTO> movementsTypes = movementsTypeService.getAllMovementsTypes();
        return new ResponseEntity<>(movementsTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementsTypeDTO> getMovementsTypeById(@PathVariable Integer id) {
        MovementsTypeDTO movementsType = movementsTypeService.getMovementsTypeById(id);
        return movementsType != null ? new ResponseEntity<>(movementsType, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovementsType(@PathVariable Integer id) {
        boolean isDeleted = movementsTypeService.deleteMovementsType(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}