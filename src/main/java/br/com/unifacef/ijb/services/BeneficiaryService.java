package br.com.unifacef.ijb.services;


import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.helpers.UserInfoHelper;
import br.com.unifacef.ijb.mappers.BeneficiaryInfoMapper;
import br.com.unifacef.ijb.mappers.BeneficiaryMapper;
import br.com.unifacef.ijb.mappers.BeneficiaryPlusFamilyMapper;
import br.com.unifacef.ijb.mappers.UserInfoMapper;
import br.com.unifacef.ijb.models.dtos.*;
import br.com.unifacef.ijb.models.entities.User;
import br.com.unifacef.ijb.models.entities.UserInfo;
import br.com.unifacef.ijb.models.enums.BeneficiaryStatus;
import br.com.unifacef.ijb.models.enums.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Meta;
import org.springframework.stereotype.Service;

import br.com.unifacef.ijb.models.entities.Beneficiary;
import br.com.unifacef.ijb.repositories.BeneficiaryRepository;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaryService {
    @Autowired
    private BeneficiaryRepository repository;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private FamilyService familyService;

    private Beneficiary save(Beneficiary beneficiary){
        return repository.save(beneficiary);
    }

    public Beneficiary getById(Integer id){
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }


    public List<BeneficiaryDTO> getAllBeneficiaries(){
        return BeneficiaryMapper.convertListBeneficiaryIntoListBeneficiaryDTO(repository.findAll());
    }

    public Beneficiary registerBeneficiary(BeneficiaryRegisterDTO beneficiaryRegister) {
        AuthorityDTO authorityDTO = authorityService.findAuthorityRole(Role.ROLE_BENEFICIARIO);
        UserInfoCreateDTO userInfoCreateDTO = UserInfoHelper.setUpUserInfoCreateDTO(authorityDTO, beneficiaryRegister);
        UserInfo userInfo = userInfoService.createUserInfo(userInfoCreateDTO);

        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setUser(userInfo.getUser());
        beneficiary.setName(beneficiaryRegister.getName() + " " + beneficiaryRegister.getLastName());
        beneficiary.setCreatedAt(LocalDateTime.now());
        beneficiary.setUpdatedAt(LocalDateTime.now());
        beneficiary.setIndicationDate(LocalDateTime.now());
        beneficiary.setMeetDescription("Whatsapp");


        return save(beneficiary);
    }


    private Beneficiary changeBeneficiaryStatus(BeneficiaryStatus status, Beneficiary beneficiary){
        beneficiary.setStatus(status);

        return beneficiary;
    }

    public BenficiaryWithFamilyDTO sendAllBeneficiaryWithAllStatus(Integer id){
        List<FamilyDTO> familiars = new ArrayList<FamilyDTO>();
        Beneficiary beneficiary = getById(id);
        BeneficiaryDTO beneficiaryDTO = BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(beneficiary);
        BenficiaryWithFamilyDTO benficiaryWithFamiliarsDTO = new BenficiaryWithFamilyDTO();


        familiars = familyService.getAllFamiliarsByBeneficiaryID(beneficiary.getId());
        benficiaryWithFamiliarsDTO = BeneficiaryPlusFamilyMapper.createBenefPlusFamil(beneficiaryDTO, familiars);

        return benficiaryWithFamiliarsDTO;
    }

    public BeneficiaryInfoDTO sendBeneficiaryUserInformations(Integer id){
        Beneficiary beneficiary = getById(id);

        UserInfo usersInfo = new UserInfo();
        BeneficiaryInfoDTO beneficiaryInfoDTO = new BeneficiaryInfoDTO();

        usersInfo = userInfoService.findByUser(beneficiary.getUser());
        beneficiaryInfoDTO = BeneficiaryInfoMapper.createBeneficiaryInfoDTO(
                BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(beneficiary),
                UserInfoMapper.convertUserInfoIntoUserInfoDTO(usersInfo)
        );

        return beneficiaryInfoDTO;
    }


    public void updateRetrievedBenefEntity(BeneficiaryDTO beneficiaryDTO, Beneficiary beneficiary){
        BeneficiaryMapper.updateBeneficiary(beneficiaryDTO, beneficiary);
    }

    public BeneficiaryDTO updateBeneficiary(BeneficiaryDTO beneficiaryDTO){
        Beneficiary beneficiary = getById(beneficiaryDTO.getId());
        updateRetrievedBenefEntity(beneficiaryDTO, beneficiary);
        beneficiary.setUpdatedAt(LocalDateTime.now());

        return BeneficiaryMapper.convertBeneficiaryIntoBeneficiaryDTO(save(beneficiary));
    }

    @Transactional
    public void deleteBeneficiary(Integer id){
        Beneficiary beneficiary = getById(id);
        save(changeBeneficiaryStatus(BeneficiaryStatus.INACTIVE, beneficiary));
        beneficiary.setDeletedAt(LocalDateTime.now());
    }

}
