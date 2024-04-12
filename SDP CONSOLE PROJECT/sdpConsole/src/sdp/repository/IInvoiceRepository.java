package sdp.repository;

import sdp.models.invoice.Invoice;

import java.util.List;

public interface IInvoiceRepository {
    void createInvoice(Invoice invoice);
    List<Invoice> getInvoices();

}
