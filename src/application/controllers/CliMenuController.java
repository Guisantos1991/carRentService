package application.controllers;


import services.VehicleServiceImpl;

import java.util.Locale;
import java.util.Scanner;


public class CliMenuController {

    public CliMenuController() {
    }

    public void showMainMenu() {

        Locale.setDefault(Locale.US);
        CustomerController customerController = new CustomerController();
        VehicleController vehicleController = new VehicleController();
        Scanner sc = new Scanner(System.in);

        int option = 100;


        while (option < 0 || option > 5) {
            System.out.println("Bem-vindo ao sistema de locação de veículos!");
            System.out.println();
            System.out.println("Selecione abaixo qual função deseja realizar:");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Veículos");
            System.out.println("3. Gerenciar Alugueis");
            System.out.println("4. Reservas");
            System.out.println("5. Sair");
            System.out.print("Digite aqui sua seleção: ");
            option = sc.nextInt();

        }
        switch(option) {
            case 1:
                customerController.start();
                break;
            case 2:
                vehicleController.start();
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
