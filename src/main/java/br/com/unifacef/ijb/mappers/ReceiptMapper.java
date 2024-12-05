package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.ReceiptCreateDTO;
import br.com.unifacef.ijb.models.dtos.ReceiptDTO;
import br.com.unifacef.ijb.models.entities.Receipt;

import java.util.ArrayList;
import java.util.List;

public class ReceiptMapper {
    public static Receipt convertReceiptDTOIntoReceipt(ReceiptCreateDTO receiptDTO) {
        return new Receipt(DonationMapper.convertDonationDTOIntoDonation(receiptDTO.getDonation()));
    }

    public static ReceiptDTO convertReceiptIntoReceiptDTO(Receipt receipt) {
        return new ReceiptDTO(
                receipt.getId(),
                DonationMapper.convertDonationIntoDonationDTO(receipt.getDonation()),
                receipt.getReceiptDate(),
                receipt.getExpiryDate()
        );
    }

    public static List<ReceiptDTO> convertListOfReceiptIntoListOfReceiptDTO(List<Receipt> receipts) {
        List<ReceiptDTO> receiptDTOs = new ArrayList<>();
        receipts.forEach(receipt -> receiptDTOs.add(convertReceiptIntoReceiptDTO(receipt)));

        return receiptDTOs;
    }

    public static void updateReceipt(ReceiptCreateDTO receiptUpdate, Receipt receipt) {
        receipt.setDonation(DonationMapper.convertDonationDTOIntoDonation(receiptUpdate.getDonation()));
        receipt.setReceiptDate(receiptUpdate.getReceiptDate());
        receipt.setExpiryDate(receiptUpdate.getExpiryDate());
    }
}
