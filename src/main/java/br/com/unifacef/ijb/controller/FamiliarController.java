package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.mappers.FamiliarMapper;
import br.com.unifacef.ijb.models.dtos.FamiliarDTO;
import br.com.unifacef.ijb.services.FamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familiar")
public class FamiliarController {

    @Autowired
    FamiliarService service;

    @PostMapping
    public ResponseEntity<FamiliarDTO> createFamiliar(@RequestBody FamiliarDTO familiarDTO) {
        return new ResponseEntity<>(service.createFamiliar(familiarDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliarDTO> getFamiliarById(@PathVariable Integer id) {
        return new ResponseEntity<>(FamiliarMapper.convertFamiliarIntoFamiliarDTO(service.getById(id)), HttpStatus.OK);
    }

    @GetMapping("/familiares/{benefId}")
    public ResponseEntity<List<FamiliarDTO>> getFamiliarsByBeneficiaryId(@PathVariable Integer benefId) {
        return new ResponseEntity<>(service.getAllFamiliarsByBeneficiaryID(benefId), HttpStatus.OK);
    }

    @GetMapping("/familiares")
    public ResponseEntity<List<FamiliarDTO>> getAllFamiliars(){
        return new ResponseEntity<>(service.getAllFamiliars(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliarDTO> updateFamiliarById(@PathVariable Integer id, FamiliarDTO familiarDTO) {
        return new ResponseEntity<>(service.updateFamiliar(familiarDTO), HttpStatus.OK);
    }

    @DeleteMapping("familiar/{id}")
    public ResponseEntity<Void> deleteFamiliarById(@PathVariable Integer id) {
        service.deleteFamiliar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
