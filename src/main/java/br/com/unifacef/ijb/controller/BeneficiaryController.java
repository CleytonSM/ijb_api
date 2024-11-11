package br.com.unifacef.ijb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.services.BeneficiaryService;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiaryController {
    
    @Autowired
    BeneficiaryService service;

    @PostMapping
    public BeneficiaryDTO createBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO){
        return service.createBeneficiary(beneficiaryDTO);
    }

    @GetMapping("/{id}")
    public BeneficiaryDTO getById(Integer id){
        return service.getByIdConvertedToDTO(id);
    }

    @GetMapping("/beneficiarios?")
    public
}
