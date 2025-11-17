package application.controllers;


import java.util.Locale;
import java.util.Scanner;


public class CliMenuController {

    public CliMenuController() {
    }

    public void showMainMenu() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int option = 100;


        while (option < 0 || option > 5) {
            System.out.println("Welcome to Car Rental System");
            System.out.println();
            System.out.println("Select the menu to access:");
            System.out.println("1. Client Management");
            System.out.println("2. Vehicle Management");
            System.out.println("3. Rent Management");
            System.out.println("4. Reservation Management");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

        }
        switch(option) {
            case 1:
                ClientController clientController = new ClientController();
                clientController.showClientMenu();
                break;
            case 2:
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                System.out.println("Exiting the application. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

}
