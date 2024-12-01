package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.MaterialCreateDTO;
import br.com.unifacef.ijb.models.dtos.MaterialDTO;
import br.com.unifacef.ijb.models.dtos.MaterialUpdateDTO;
import br.com.unifacef.ijb.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ijb/material")
public class MaterialController {
    @Autowired
    private MaterialService service;

    @PostMapping("/register")
    public ResponseEntity<Void> registerMaterial(@RequestBody MaterialCreateDTO material) {
        service.createMaterial(material);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<MaterialDTO>> findMaterialByFilter(@RequestParam String search) {
        return new ResponseEntity<>(service.findByFilter(search), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteMaterial(@RequestParam Integer id) {
        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> deleteMaterial(@RequestBody MaterialUpdateDTO materialUpdate) {
        service.updateMaterial(materialUpdate);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
