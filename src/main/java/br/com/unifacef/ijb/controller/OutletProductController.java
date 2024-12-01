package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductFilterResponseDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductUpdateDTO;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.services.OutletProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ijb/outletProduct")
public class OutletProductController {
    @Autowired
    private OutletProductService service;

    @PostMapping("/register")
    public ResponseEntity<Void> registerOutletProduct(@RequestBody OutletProductCreateDTO outletProductCreate) {
        service.createOutletProduct(outletProductCreate);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/filter")
    public ResponseEntity<OutletProductFilterResponseDTO> findOutletProductByFilter(@RequestParam String search) {
        return new ResponseEntity<>(service.findByFilter(search), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteOutletProductById(@RequestParam Integer id,
                                                        @RequestParam OutletProductStatus status) {
        service.deleteOutletProduct(id, status);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateOutletProductById(@RequestBody OutletProductUpdateDTO outletProductUpdate) {
        service.updateOutletProduct(outletProductUpdate);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
