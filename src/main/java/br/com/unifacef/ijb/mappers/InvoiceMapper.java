package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.InvoicesCreateDTO;
import br.com.unifacef.ijb.models.dtos.InvoicesDTO;
import br.com.unifacef.ijb.models.entities.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceMapper {
    public static Invoice convertInvoiceCreateDTOIntoInvoice(InvoicesCreateDTO dto) {
        return new Invoice(
                MovementMapper.convertMovementDTOIntoMovement(dto.getMovement()),
                dto.getInvoicePhoto()
        );
    }

    public static InvoicesDTO convertInvoiceEntityToDTO(Invoice invoice) {
        return new InvoicesDTO(
                invoice.getId(),
                MovementMapper. convertMovementIntoMovementDTO(invoice.getMovement()),
                invoice.getInvoicePhoto()
        );
    }

    public static List<InvoicesDTO> convertListOfInvoiceIntoListOfInvoiceDTO(List<Invoice> invoices) {
        List<InvoicesDTO> invoiceDTOs = new ArrayList<>();

        invoices.forEach(invoice -> invoiceDTOs.add(convertInvoiceEntityToDTO(invoice)));

        return invoiceDTOs;
    }

    public static void updateInvoice(InvoicesCreateDTO invoiceUpdate, Invoice invoice) {
        invoice.setMovement(MovementMapper.convertMovementDTOIntoMovement(invoiceUpdate.getMovement()));
        invoice.setInvoicePhoto(invoiceUpdate.getInvoicePhoto());
    }
}
