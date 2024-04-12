package sdp.repository;

import sdp.models.invoice.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements IInvoiceRepository {

    List<Invoice> invoiceList = new ArrayList<>();

    @Override
    public void createInvoice(Invoice invoice) {
        invoiceList.add(invoice);
        System.out.println("Invoice created" + invoice.getTotalAmount());
    }

    @Override
    public List<Invoice> getInvoices() {
        return invoiceList;
    }


}
