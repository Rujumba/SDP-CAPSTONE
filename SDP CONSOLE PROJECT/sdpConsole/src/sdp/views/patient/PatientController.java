package sdp.views.patient;

import java.util.List;
import java.util.Scanner;
import sdpConsole.constants.DummyData;

import sdp.models.patient.Patient;
import sdp.views.accountReconciliation.services.PatientService;
import sdp.views.accountReconciliation.services.PatientServiceFactory;

public class PatientController {
    private static Scanner scanner = new Scanner(System.in);
    private static DummyData dummyData = new DummyData();
    private static PatientService patientService;

    public void choosePatientOption(){

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Assign Service");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                scanner.nextLine(); // Consume newline character
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("You selected Registation of a Patient");
                    Patient patient = createPatient();
                    patientService = PatientServiceFactory.createService(patient.getFacilityType());
                    patientService.savePatient(patient);
                    break;
                case 2:
                    System.out.println("You selected Viewing Patients");
                    List<Patient> patientsList = patientService.getAllPatients();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("| %-10s | %-20s | %-10s | %-15s | %-15s | %-20s | %-20s | %-10s | %-10s |%n",
                            "ID", "Name", "Gender", "Phone Number", "Facility Type", "Doctor Name", "Admission Date", "District", "Prescription");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    for (Patient patient1 : patientsList) {
                        System.out.printf("| %-10s | %-20s | %-10s | %-15s | %-15s | %-20s | %-20s | %-10s | %-10s |%n",
                                patient1.getId(), patient1.getName(), patient1.getGender(), patient1.getPhoneNumber(), patient1.getFacilityType(),
                                patient1.getDoctorName(), patient1.getAdmissionDate(), patient1.getDistrict(), patient1.getPrescription());
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    
                    break;
                case 3:
                    System.out.println("You selected Delete Patient");
                    deletePatient();
                    break;
                case 4:
                    System.out.println("You selected Assign Service");
                    // Call method to handle assigning a service
                    break;
                case 5:
                    System.out.println("\nExiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nInvalid choice. Please choose a number between 1 and 5.");
            }
        }
    }

        private static Patient createPatient() {
            Patient patient = new Patient();

            // Prompt the user to choose district from the dummy data list
            List<String> districts = dummyData.getDistrict();
            System.out.println("\nChoose a district:\n");
            for (int i = 0; i < districts.size(); i++) {
                System.out.println((i + 1) + ". " + districts.get(i));
            }
            System.out.print("\nEnter the number corresponding to the district:\n ");
            int districtChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            if (districtChoice >= 1 && districtChoice <= districts.size()) {
                String chosenDistrict = districts.get(districtChoice - 1);
                patient.setDistrict(chosenDistrict);
            } else {
                System.out.println("\nInvalid district choice.");
                return null;
            }

            // Prompt the user to choose health facility from the dummy data list
            List<String> facilities = dummyData.getHealthFacility();
            System.out.println("Choose a health facility:\n");
            for (int i = 0; i < facilities.size(); i++) {
                System.out.println((i + 1) + ". " + facilities.get(i));
            }
            System.out.print("Enter the number corresponding to the health facility: ");
            int facilityChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            if (facilityChoice >= 1 && facilityChoice <= facilities.size()) {
                String chosenFacility = facilities.get(facilityChoice - 1);
                patient.setFacilityType(chosenFacility);
            } else {
                System.out.println("Invalid health facility choice.");
                return null;
            }

            // Capture other patient information based on the chosen facility type
            System.out.print("\nEnter patient's name:\n ");
            String name = scanner.nextLine();
            patient.setName(name);

            System.out.print("\nEnter patient's age:\n ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            patient.setAge(age);

            System.out.print("\nEnter patient's gender:\n ");
            String gender = scanner.nextLine();
            patient.setGender(gender);

            System.out.print("\nEnter patient's date of birth (YYYY-MM-DD):\n ");
            String dob = scanner.nextLine();
            patient.setDateOfBirth(dob);

            System.out.print("\nEnter patient's address:\n ");
            String address = scanner.nextLine();
            patient.setAddress(address);

            System.out.print("\nEnter patient's phone number:\n ");
            String phoneNumber = scanner.nextLine();
            patient.setPhoneNumber(phoneNumber);

            System.out.print("\nEnter patient's email:\n ");
            String email = scanner.nextLine();
            patient.setEmail(email);

            // Additional attributes based on facility type
            if ("Hospital".equalsIgnoreCase(patient.getFacilityType())) {
                // Specific attributes for the hospital
                System.out.print("\nEnter patient's admission date:\n ");
                String admissionDate = scanner.nextLine();
                patient.setAdmissionDate(admissionDate);

                //capture the doctor's name
                System.out.print("\nAssign Doctor to patient:\n ");
                String doctorName = scanner.nextLine();
                patient.setDoctorName(doctorName);


            } else if ("Clinic".equalsIgnoreCase(patient.getFacilityType())) {
                 // Specific attributes for the clinic
                System.out.print("\nEnter patient's medication:\n ");
                String medication = scanner.nextLine();
                patient.setMedication(medication);
                
            } else if ("Pharmacy".equalsIgnoreCase(patient.getFacilityType())) {
                // Specific attributes for pharmacy
                System.out.print("\nEnter patient's prescription:\n ");
                String prescription = scanner.nextLine();
                patient.setPrescription(prescription);
            }
                return patient;
            }

            private static void deletePatient() {
                while (true) {
                    // Retrieve the list of patients
                    List<Patient> patientsList = patientService.getAllPatients();
                    
                    // Display the list of patients with their IDs
                    System.out.println("List of Patients:");
                    for (int i = 0; i < patientsList.size(); i++) {
                        System.out.println((i + 1) + ". " + patientsList.get(i).getName());
                    }
                    
                    // Prompt the user to enter the ID of the patient to delete
                    System.out.print("Enter the ID of the patient to delete (or 0 to cancel): ");
                    int patientIdToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    
                    // Check if the user wants to cancel
                    if (patientIdToDelete == 0) {
                        System.out.println("Operation cancelled.");
                        return;
                    }
                    
                    // Check if the entered ID is valid
                    if (patientIdToDelete >= 1 && patientIdToDelete <= patientsList.size()) {
                        // Confirm deletion
                        System.out.print("Are you sure you want to delete this patient? (yes/no): ");
                        String confirmation = scanner.nextLine().trim().toLowerCase();
                        
                        if (confirmation.equals("yes")) {
                            // Call the deletePatient method from PatientService
                            patientService.deletePatient(patientsList.get(patientIdToDelete - 1).getId());
                            System.out.println("Patient deleted successfully.");
                            return;
                        } else if (confirmation.equals("no")) {
                            System.out.println("Deletion cancelled.");
                            return;
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    } else {
                        System.out.println("Invalid patient ID. Please try again.");
                    }
                }
            }
            
            
}
