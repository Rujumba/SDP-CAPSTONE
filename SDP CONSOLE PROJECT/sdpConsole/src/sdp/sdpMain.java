package sdp;

import java.util.Scanner;



public class sdpMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Patients");
            System.out.println("2. Services Offered");
            System.out.println("3. Payments");
            System.out.println("4. Chat");
            System.out.println("5. Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice;

            // Validate input to ensure it's an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("You chose Patients.");
                        // Add your Patients functionality here
                        break;
                    case 2:
                        System.out.println("You chose Services Offered.");
                        // Add your Services Offered functionality here
                        break;
                    case 3:
                        System.out.println("You chose Payments.");
                        // Add your Payments functionality here
                        break;
                    case 4:
                        System.out.println("You chose Chat.");
                        // Add your Chat functionality here
                        break;
                    case 5:
                        System.out.println("You chose Accounts.");
                        // Add your Accounts functionality here
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close();
    }

}
