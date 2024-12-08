package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.OutletProductCreateDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductResponseDTO;
import br.com.unifacef.ijb.models.dtos.OutletProductUpdateDTO;
import br.com.unifacef.ijb.models.enums.OutletProductStatus;
import br.com.unifacef.ijb.services.OutletProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<OutletProductResponseDTO>> findAllOutletProduct() {
        return new ResponseEntity<>(service.findByFilter(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOutletProductById(@PathVariable("id") Integer id) {
        service.deleteOutletProduct(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateOutletProductById(@PathVariable("id") Integer id,
                                                        @RequestBody OutletProductUpdateDTO outletProductUpdate) {
        service.updateOutletProduct(id, outletProductUpdate);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
