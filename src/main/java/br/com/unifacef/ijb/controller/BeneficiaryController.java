package br.com.unifacef.ijb.controller;

import java.util.List;

import br.com.unifacef.ijb.mappers.BeneficiaryMapper;
import br.com.unifacef.ijb.models.dtos.BeneficiaryInfoDTO;
import br.com.unifacef.ijb.models.dtos.BeneficiaryRegisterDTO;
import br.com.unifacef.ijb.models.dtos.BenficiaryWithFamilyDTO;
import br.com.unifacef.ijb.models.entities.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.services.BeneficiaryService;

@RestController
@RequestMapping("/api/ijb/beneficiarios")
public class BeneficiaryController {

    @Autowired
    BeneficiaryService service;

    @PostMapping
    public ResponseEntity<Beneficiary> createBeneficiary(@RequestBody BeneficiaryRegisterDTO beneficiaryRegisterDTO){
        return new ResponseEntity<>(service.registerBeneficiary(beneficiaryRegisterDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiaryDTO> getBeneficiaryById(@PathVariable Integer id){
        return new ResponseEntity<>(BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(service.getById(id)), HttpStatus.OK);
    }

    @GetMapping("/userdata/{id}")
    public ResponseEntity<BeneficiaryInfoDTO> getBeneficiaryUserInformations(@PathVariable Integer id){
         return new ResponseEntity<>(service.sendBeneficiaryUserInformations(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<BeneficiaryDTO>> getAllBeneficiaries(){
        return new ResponseEntity<>(service.getAllBeneficiaries(), HttpStatus.OK);
    }

    @GetMapping("/familiars/{id}")
    public ResponseEntity<BenficiaryWithFamilyDTO> getAllBeneficiariesDatas(@PathVariable Integer id){
        return new ResponseEntity<>(service.sendAllBeneficiaryWithAllStatus(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBeneficiary(@PathVariable Integer id){
        service.deleteBeneficiary(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBeneficiary(@PathVariable Integer id, @RequestBody BeneficiaryDTO beneficiaryDTO){
        service.updateBeneficiary(beneficiaryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
