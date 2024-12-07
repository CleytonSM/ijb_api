package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.ConstructionCreateDTO;
import br.com.unifacef.ijb.models.dtos.ConstructionDTO;
import br.com.unifacef.ijb.models.dtos.ConstructionUpdateDTO;
import br.com.unifacef.ijb.services.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/obras")
public class ConstructionController {
    @Autowired
    private ConstructionService service;

    @PostMapping("/register")
    public ResponseEntity<Void> registerConstruction(@RequestBody ConstructionCreateDTO constructionCreate) {
        service.createConstruction(constructionCreate);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ConstructionDTO>> findAllConstruction() {
        return new ResponseEntity<>(service.findByFilter(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteConstructionById(@RequestParam Integer id) {
        service.deleteConstruction(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateConstructionById(@PathVariable("id") Integer id,
                                                        @RequestBody ConstructionUpdateDTO constructionUpdate) {
        service.updateConstruction(id, constructionUpdate);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}