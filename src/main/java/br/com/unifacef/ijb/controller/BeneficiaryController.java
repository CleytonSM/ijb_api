package br.com.unifacef.ijb.controller;

import java.util.List;

import br.com.unifacef.ijb.mappers.BeneficiaryMapper;
import br.com.unifacef.ijb.models.dtos.BenficiaryPlusFamiliarsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public BeneficiaryDTO getBeneficiaryById(@PathVariable Integer id){
        return BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(service.getById(id));
    }

    @GetMapping("/beneficiarios?")
    public List<BeneficiaryDTO> getAllBeneficiaries(){
        return service.getAllBeneficiaries();
    }

    @GetMapping("/beneficiarios?/getAllData/{id}")
    public BenficiaryPlusFamiliarsDTO getAllBeneficiariesDatas(@PathVariable Integer id){
        return service.sendAllBeneficiaryWithAllStatus(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable Integer id){
        service.deleteBeneficiary(id);
    }

    @PutMapping
    public BeneficiaryDTO updateBeneficiary(BeneficiaryDTO beneficiaryDTO){
        return service.updateBeneficiary(beneficiaryDTO);
    }


}
