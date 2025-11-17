package application.controllers;

import application.usecases.CreateClient;
import domain.enums.ClientStatus;

import java.util.Scanner;

public class ClientController {

    CreateClient createClient = new CreateClient();

    public ClientController() {
    }
 public void showClientMenu() {

     Scanner sc = new Scanner(System.in);
     int option = 100;

     while (option < 0 || option > 5) {

         System.out.println();
         System.out.println("Client Management Menu");
         System.out.println("1. Add Client");
         System.out.println("2. View Clients");
         System.out.println("3. Update Client");
         System.out.println("4. Delete Client");
         System.out.println("5. Back to Main Menu");
         System.out.print("Enter your choice: ");
         option = sc.nextInt();
     }

     switch (option) {
         case 1:
             System.out.println();
             System.out.println("Add New Client: ");
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Phone: ");
                String phone = sc.nextLine();
                System.out.print("Status (ACTIVE/INACTIVE): ");
                String statusInput = sc.nextLine();
                createClient.execute(id, name, cpf, email, phone, ClientStatus.valueOf(statusInput));
                showClientMenu();
                break;
            case 2:
                createClient.executeReturn();
                showClientMenu();
                break;
                default:
                    System.out.println("Returning to Main Menu.");
                    break;

     }
 }
}
