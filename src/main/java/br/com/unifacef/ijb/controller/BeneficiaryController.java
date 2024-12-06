package br.com.unifacef.ijb.controller;

import java.util.List;

import br.com.unifacef.ijb.mappers.BeneficiaryMapper;
import br.com.unifacef.ijb.models.dtos.BenficiaryPlusFamiliarsDTO;
import br.com.unifacef.ijb.models.dtos.UserPlusUserInfoDTO;
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
    public ResponseEntity<BeneficiaryDTO> createBeneficiaryC(@RequestBody BeneficiaryDTO beneficiaryDTO){
        return new ResponseEntity<>(service.createBeneficiary(beneficiaryDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiaryDTO> getBeneficiaryById(@PathVariable Integer id){
        return new ResponseEntity<>(BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(service.getById(id)), HttpStatus.OK);
    }

    @GetMapping("/getAllData/getUserInfos/{id}")
    public ResponseEntity<UserPlusUserInfoDTO> getUserPlusUserInfoData(@PathVariable Integer id){
        return new ResponseEntity<>(service.sendUserAndUserInfoByBeneficiaryId(id), HttpStatus.OK);
    }

    @GetMapping("/") //mudar nome de rotas com beneficiario no começo
    public ResponseEntity<List<BeneficiaryDTO>> getAllBeneficiaries(){
        return new ResponseEntity<>(service.getAllBeneficiaries(), HttpStatus.OK);
    }

    @GetMapping("/beneficiarios?/getAllData/{id}")
    public ResponseEntity<BenficiaryPlusFamiliarsDTO> getAllBeneficiariesDatas(@PathVariable Integer id){
        return new ResponseEntity<>(service.sendAllBeneficiaryWithAllStatus(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiary(@PathVariable Integer id){
        service.deleteBeneficiary(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BeneficiaryDTO> updateBeneficiary(BeneficiaryDTO beneficiaryDTO){
        return new ResponseEntity<>(service.updateBeneficiary(beneficiaryDTO), HttpStatus.OK);
    }


}
