package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.mappers.FamilyMapper;
import br.com.unifacef.ijb.models.dtos.FamilyDTO;
import br.com.unifacef.ijb.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/familia")
public class FamilyController {

    @Autowired
    FamilyService service;

    @PostMapping
    public ResponseEntity<FamilyDTO> registerFamily(@RequestBody FamilyDTO familiarDTO) {
        return new ResponseEntity<>(service.createFamily(familiarDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyDTO> getFamiliarById(@PathVariable Integer id) {
        return new ResponseEntity<>(FamilyMapper.convertFamiliarIntoFamiliarDTO(service.getById(id)), HttpStatus.OK);
    }

    @GetMapping("/beneficiario/{benefId}")
    public ResponseEntity<List<FamilyDTO>> getFamiliarsByBeneficiaryId(@PathVariable Integer benefId) {
        return new ResponseEntity<>(service.getAllFamiliarsByBeneficiaryID(benefId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FamilyDTO>> getAllFamiliars(){
        return new ResponseEntity<>(service.getAllFamiliars(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateFamiliarById(@PathVariable Integer id, FamilyDTO familiarDTO) {
        service.updateFamily(familiarDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFamiliarById(@PathVariable Integer id) {
        service.deleteFamiliar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
