package br.com.unifacef.ijb.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacef.ijb.mappers.BeneficiaryMapper;
import br.com.unifacef.ijb.models.dtos.BeneficiaryDTO;
import br.com.unifacef.ijb.models.entities.Beneficiary;
import br.com.unifacef.ijb.repositories.BeneficiaryRepository;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class BeneficiaryService {
    
    @Autowired
    BeneficiaryRepository inject;

    @Autowired
    BeneficiaryMapper converter;

    public BeneficiaryDTO InsertBeneficiary(BeneficiaryDTO beneficiaryDTO){
        Beneficiary entity = converter.convertBeneficiaryDTOIntoBeneficiary(beneficiaryDTO);
        Beneficiary savedEntity = inject.save(entity);
        return converter.convertBeneficiaryIntoBeneficiaryDTO(savedEntity);
    }

    public List<BeneficiaryDTO> findAllBeneficiaries(){
        List<Beneficiary> beneficiary = inject.findAll();
        return beneficiary.stream().map(converter::convertBeneficiaryDTOIntoBeneficiary).collect(Collectors.toList());
    }

}
