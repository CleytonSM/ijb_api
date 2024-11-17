package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.mappers.FamiliarMapper;
import br.com.unifacef.ijb.models.dtos.FamiliarDTO;
import br.com.unifacef.ijb.services.FamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familiar")
public class FamilyController {

    @Autowired
    FamiliarService service;

    @PostMapping
    public FamiliarDTO createFamiliar(@RequestBody FamiliarDTO familiarDTO) {
        return service.createFamiliar(familiarDTO);
    }

    @GetMapping("/{id}")
    public FamiliarDTO getFamiliarById(@PathVariable Integer id) {
        return FamiliarMapper.convertFamiliarIntoFamiliarDTO(service.getById(id));
    }

    @GetMapping("/familiares/{benefId}")
    public List<FamiliarDTO> getFamiliarsByBeneficiaryId(@PathVariable Integer benefId) {
        return service.getAllFamiliarsByBeneficiaryID(benefId);
    }

    @GetMapping("/familiares")
    public List<FamiliarDTO> getAllFamiliars(){
        return service.getAllFamiliars();
    }

    @PutMapping("/{id}")
    public FamiliarDTO deleteFamiliarById(@PathVariable Integer id, FamiliarDTO familiarDTO) {
        return service.updateFamiliar(familiarDTO);
    }
}
