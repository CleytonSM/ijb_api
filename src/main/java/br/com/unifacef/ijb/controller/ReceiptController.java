package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.models.dtos.ReceiptCreateDTO;
import br.com.unifacef.ijb.models.dtos.ReceiptDTO;
import br.com.unifacef.ijb.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<ReceiptDTO> createReceipt(@RequestBody ReceiptCreateDTO receiptDTO) {
        return ResponseEntity.ok(receiptService.createReceipt(receiptDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptDTO> getReceiptById(@PathVariable Integer id) {
        return ResponseEntity.ok(receiptService.getReceiptById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReceiptDTO>> getAllReceipts() {
        return ResponseEntity.ok(receiptService.getAllReceipts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceiptDTO> updateReceipt(@PathVariable Integer id, @RequestBody ReceiptCreateDTO receiptDTO) {
        return ResponseEntity.ok(receiptService.updateReceipt(id, receiptDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable Integer id) {
        receiptService.deleteReceipt(id);
        return ResponseEntity.noContent().build();
    }
}