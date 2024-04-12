package sdp.views.medicalServiceView;

import sdp.models.medicalServiceModel.MedicalService;
import sdp.repository.IMedicalServiceRepository;
import sdp.repository.MedicalServiceRepository;
import sdp.views.invoiceView.InvoiceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalServiceView {
    private InvoiceView invoiceView;
    IMedicalServiceRepository medicalServiceRepository;
    public List<MedicalService> medicalServiceList = new ArrayList<>();
    MedicalService medicalService;

    public MedicalServiceView() {
        this.invoiceView = InvoiceView.getInstance();
        this.medicalServiceRepository = new MedicalServiceRepository();
    }

    public void displayMedicalService() {
        Scanner scanner = new Scanner(System.in);

        boolean display = false;

        while(!display) {
            System.out.println("--------------Medical Services View-------------");
            System.out.println("Choose an option:");
            System.out.println("1. View Medical Service");
            System.out.println("2. Add Medical Service");
            System.out.println("3. Exit Medical Service");

            System.out.print("Enter your choice: ");
            int choice;

            // Validate input to ensure it's an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("------------------ Displaying Medical Service. -----------------");
                            medicalServiceList = medicalServiceRepository.getMedicalServices();
                            int id = 1;
                            for (MedicalService medicalService : medicalServiceList) {
                                System.out.println(id + " . " + medicalService.getServiceName());
                                id += 1;
                            }
                        break;
                    case 2:
                        System.out.println("------------ Adding a Medical Service. ----------------");

                        System.out.println("Enter medical service name: ");
                        String medicalServiceName = scanner.nextLine();

                        System.out.println("Enter medical service price: ");
                        double medicalServicePrice = scanner.nextDouble();

                        medicalServiceRepository.save(new MedicalService( medicalServiceName, medicalServicePrice));


                        invoiceView.update(new MedicalService( medicalServiceName, medicalServicePrice));

                        System.out.println("Medical Service added successfully. " + medicalServiceName + " and price: " + medicalServicePrice);
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        display = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
