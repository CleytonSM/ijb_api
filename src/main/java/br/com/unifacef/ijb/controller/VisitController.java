package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.mappers.VisitMapper;
import br.com.unifacef.ijb.models.dtos.VisitDTO;
import br.com.unifacef.ijb.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visita")
public class VisitController {
    @Autowired
    VisitService service;

    @PostMapping
    public VisitDTO createVisit(@RequestBody VisitDTO visitDTO) {
        return service.createVisit(visitDTO);
    }

    @GetMapping("/{id}")
    public VisitDTO getVisitById(@PathVariable Integer id) {
        return VisitMapper.convertVisitIntoVisitDTO(service.getById(id));
    }

    @GetMapping("/visitas/{benefId}")
    public List<VisitDTO> getVisitsByBenefId(@PathVariable Integer benefId) {
        return service.getVisitsByBeneficiaryId(benefId);
    }

    @PutMapping
    public VisitDTO updateVisit(VisitDTO visitDTO) {
        return service.updateVisit(visitDTO);
    }
}
