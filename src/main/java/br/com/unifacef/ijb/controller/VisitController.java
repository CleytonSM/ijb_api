package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.mappers.VisitMapper;
import br.com.unifacef.ijb.models.dtos.VisitDTO;
import br.com.unifacef.ijb.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visita")
public class VisitController {
    @Autowired
    VisitService service;

    @PostMapping
    public ResponseEntity<VisitDTO> createVisit(@RequestBody VisitDTO visitDTO) {
        return new ResponseEntity<>(service.createVisit(visitDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDTO> getVisitById(@PathVariable Integer id) {
        return new ResponseEntity<>(VisitMapper.convertVisitIntoVisitDTO(service.getById(id)), HttpStatus.OK);
    }

    @GetMapping("/visitas/{benefId}")
    public ResponseEntity<List<VisitDTO>> getVisitsByBenefId(@PathVariable Integer benefId) {
        return new ResponseEntity<>(service.getVisitsByBeneficiaryId(benefId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VisitDTO> updateVisit(VisitDTO visitDTO) {
        return new ResponseEntity<>(service.updateVisit(visitDTO), HttpStatus.OK);
    }


}
