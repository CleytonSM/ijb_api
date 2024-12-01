package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.RebateMapper;
import br.com.unifacef.ijb.mappers.SaleMapper;
import br.com.unifacef.ijb.mappers.TagsMapper;
import br.com.unifacef.ijb.models.dtos.RebateCreateDTO;
import br.com.unifacef.ijb.models.dtos.RebateDTO;
import br.com.unifacef.ijb.models.dtos.TagsDTO;
import br.com.unifacef.ijb.models.entities.Rebate;
import br.com.unifacef.ijb.models.entities.Tags;
import br.com.unifacef.ijb.repositories.RebateRepository;
import br.com.unifacef.ijb.repositories.TagsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RebateService {
    @Autowired
    private RebateRepository repository;
    @Autowired
    private ExchangeService exchangeService;

    public Rebate save(Rebate rebate) {
        return repository.save(rebate);
    }

    public Rebate getById(Integer id) {
        return OptionalHelper.getOptionalEntity(repository.findById(id));
    }

    @Transactional
    public RebateDTO createRebate(RebateCreateDTO rebateCreate) {
        Rebate rebate = RebateMapper.convertRebateCreateDTOIntoRebate(rebateCreate);

        return RebateMapper.convertRebateIntoRebateDTO(save(rebate));
    }

    public List<RebateDTO> getAllRebates() {
        return RebateMapper.convertListOfRebateIntoListOfRebateDTO(repository.findAll());
    }

    @Transactional
    public RebateDTO updateRebate(RebateDTO rebateUpdate) {
        Rebate rebate = getById(rebateUpdate.getId());
        updateRetrievedEntity(rebateUpdate, rebate);

        return RebateMapper.convertRebateIntoRebateDTO(save(rebate));
    }

    private void updateRetrievedEntity(RebateDTO rebateUpdate, Rebate rebate) {
        RebateMapper.updateRebate(rebateUpdate, rebate);
    }

    public List<RebateDTO> findByFilter(String search) {
        List<Rebate> rebates = findRebatesBySearch(search);
        if(Optional.ofNullable(rebates).isPresent() && !rebates.isEmpty()) {
            return RebateMapper.convertListOfRebateIntoListOfRebateDTO(rebates);
        }

        return null;
    }

    private List<Rebate> findRebatesBySearch(String search) {
        return repository.findAllBySearch(search);
    }

    public void deleteById(Integer id) {
        repository.delete(getById(id));
    }
}
