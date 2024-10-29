package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.ExchangeMapper;
import br.com.unifacef.ijb.mappers.RebateMapper;
import br.com.unifacef.ijb.models.dtos.ExchangeDTO;
import br.com.unifacef.ijb.models.dtos.RebateCreateDTO;
import br.com.unifacef.ijb.models.dtos.RebateDTO;
import br.com.unifacef.ijb.models.entities.Rebate;
import br.com.unifacef.ijb.repositories.RebateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Transactional
    public void deleteRebate(Integer id) {
        Rebate rebate = getById(id);
        exchangeService.deleteExchange(rebate.getExchange().getId());
    }

    private void updateRetrievedEntity(RebateDTO rebateUpdate, Rebate rebate) {
        RebateMapper.updateRebate(rebateUpdate, rebate);
    }
}
