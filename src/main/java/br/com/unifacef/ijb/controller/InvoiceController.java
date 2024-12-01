//package br.com.unifacef.ijb.controller;
//
//import br.com.unifacef.ijb.models.dtos.InvoicesCreateDTO;
//import br.com.unifacef.ijb.models.dtos.InvoicesDTO;
//import br.com.unifacef.ijb.services.InvoiceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//@RequestMapping("/api/ijb/invoice")
//public class InvoiceController {
//    @Autowired
//    private InvoiceService invoiceService;
//
//    @PostMapping
//    public ResponseEntity<InvoicesDTO> createInvoice(@RequestBody InvoicesCreateDTO invoiceDTO) {
//        return new ResponseEntity<>(invoiceService.createInvoice(invoiceDTO), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<InvoicesDTO> getInvoiceById(@PathVariable Integer id) {
//        return new ResponseEntity<>(invoiceService.getInvoiceById(id), HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<InvoicesDTO>> getAllInvoices() {
//        return new ResponseEntity<>(invoiceService.getAllInvoices(), HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<InvoicesDTO> updateInvoice(@PathVariable Integer id, @RequestBody InvoicesCreateDTO invoiceDTO) {
//        return new ResponseEntity<>(invoiceService.updateInvoice(id, invoiceDTO), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteInvoice(@PathVariable Integer id) {
//        invoiceService.deleteInvoice(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}