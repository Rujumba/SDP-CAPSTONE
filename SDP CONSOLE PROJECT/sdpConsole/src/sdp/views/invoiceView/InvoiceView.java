package sdp.views.invoiceView;

import sdp.models.invoice.Invoice;
import sdp.models.medicalServiceModel.MedicalService;
import sdp.repository.IInvoiceRepository;
import sdp.repository.InvoiceRepository;
import sdp.views.MedicalServiceObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceView implements MedicalServiceObserver {

    private static InvoiceView instance;
    private IInvoiceRepository invoiceRepository;
    private List<Invoice> invoiceList = new ArrayList<>();
    private List<MedicalService> medicalServiceList = new ArrayList<>();

    private InvoiceView() {
        invoiceRepository = new InvoiceRepository();
    }

    public static synchronized InvoiceView getInstance() {
        if (instance == null) {
            instance = new InvoiceView();
        }
        return instance;

    }
    @Override
    public void update(MedicalService medicalService) {
        int invoiceId = 1;
        medicalServiceList.add(medicalService);
        double totalAmount = 0.0;
        for(MedicalService service : medicalServiceList) {
           totalAmount += medicalService.getServicePrice();
        }
        invoiceRepository.createInvoice(new Invoice(invoiceId, medicalServiceList, totalAmount ));

        System.out.println("Invoice ID: " + invoiceId + "\nTotal Amount: " + totalAmount);
    }

    public void displayInvoice() {
        Scanner scanner = new Scanner(System.in);

        boolean display = false;

        while(!display) {
            System.out.println("-------------- Invoice View -------------");
            System.out.println("Choose an option:");
            System.out.println("1. View Invoice");
            System.out.println("2. Exit Medical Service");

            System.out.print("Enter your choice: ");
            int choice;

            // Validate input to ensure it's an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("------------------ Displaying Invoice. -----------------");
                            invoiceList = invoiceRepository.getInvoices();
                            if(invoiceList.isEmpty()) {
                                System.out.println("No invoices found");
                            } else {
                                for(Invoice invoice : invoiceList) {
                                    System.out.println("This is the total amount " + invoice.getTotalAmount());
                                }
                            }

                        break;

                    case 2:
                        System.out.println("Exiting...");
                        display = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public IInvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<MedicalService> getMedicalServiceList() {
        return medicalServiceList;
    }

    public void setMedicalServiceList(List<MedicalService> medicalServiceList) {
        this.medicalServiceList = medicalServiceList;
    }
}
