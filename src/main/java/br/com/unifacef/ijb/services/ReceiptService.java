package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.ReceiptMapper;
import br.com.unifacef.ijb.models.dtos.ReceiptCreateDTO;
import br.com.unifacef.ijb.models.dtos.ReceiptDTO;
import br.com.unifacef.ijb.models.entities.Receipt;
import br.com.unifacef.ijb.repositories.ReceiptRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;

    public Receipt save(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Transactional
    public ReceiptDTO createReceipt(ReceiptCreateDTO receiptDTO) {
        Receipt receipt = ReceiptMapper.convertReceiptDTOIntoReceipt(receiptDTO);
        receipt = save(receipt);
        return ReceiptMapper.convertReceiptIntoReceiptDTO(receipt);
    }

    public List<ReceiptDTO> getAllReceipts() {
        return ReceiptMapper.convertListOfReceiptIntoListOfReceiptDTO(receiptRepository.findAll());
    }

    public ReceiptDTO getReceiptById(Integer id) {
        Receipt receipt = OptionalHelper.getOptionalEntity(receiptRepository.findById(id));
        return ReceiptMapper.convertReceiptIntoReceiptDTO(receipt);
    }

    @Transactional
    public ReceiptDTO updateReceipt(Integer id, ReceiptCreateDTO receiptDTO) {
        Receipt existingReceipt = OptionalHelper.getOptionalEntity(receiptRepository.findById(id));
        ReceiptMapper.updateReceipt(receiptDTO, existingReceipt);
        Receipt updatedReceipt = receiptRepository.save(existingReceipt);

        return ReceiptMapper.convertReceiptIntoReceiptDTO(updatedReceipt);
    }

    @Transactional
    public void deleteReceipt(Integer id) {
        Receipt receipt = OptionalHelper.getOptionalEntity(receiptRepository.findById(id));
        receiptRepository.delete(receipt);
    }

}
