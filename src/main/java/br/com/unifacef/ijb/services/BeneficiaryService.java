package br.com.unifacef.ijb.services;


import br.com.unifacef.ijb.mappers.BeneficiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.models.entities.Beneficiary;
import br.com.unifacef.ijb.repositories.BeneficiaryRepository;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class BeneficiaryService {
    
    @Autowired
    private BeneficiaryRepository repository;


//    public BeneficiaryDTO InsertBeneficiary(BeneficiaryDTO beneficiaryDTO){
//        Beneficiary entity = BeneficiaryMapper.convertBeneficiaryDTOIntoBeneficiary(beneficiaryDTO);
//        Beneficiary savedEntity = repository.save(entity);
//        return BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(savedEntity);
//    }
//
//    public List<BeneficiaryDTO> findAllBeneficiaries(){
//        List<Beneficiary> beneficiary = repository.findAll();
//        return beneficiary.stream().map(convertBeneficiaryDTOIntoBeneficiary).collect(Collectors.toList());
//    }

}
