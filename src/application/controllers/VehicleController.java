package application.controllers;

import infraestructures.repository.VehicleRepository;
import services.CustomerService;
import services.VehicleService;
import services.VehicleServiceImpl;

import java.sql.SQLOutput;
import java.util.Scanner;

public class VehicleController {

    private final VehicleServiceImpl vehicleService;
    private final CustomerController customerController;
    private final CliMenuController cliMenuController;
    Scanner scanner = new Scanner(System.in);


    public VehicleController() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        this.vehicleService = new VehicleServiceImpl(vehicleRepository);
        this.customerController = new CustomerController();
        this.cliMenuController = new CliMenuController();
    }

    public void start() {
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> vehicleService.registerVehicle();
                case 2 -> vehicleService.updateVehicle();
                case 3 -> vehicleService.changeVehicleStatus();
                case 4 -> vehicleService.findAvailableVehicles();
                case 5 -> cliMenuController.showMainMenu();
                case 6 -> customerController.start();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (option != 0);
    }

    private void displayMenu() {
        System.out.println("\n=== MENU DE VEÍCULOS ===");
        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Atualizar Veículo");
        System.out.println("3 - Alterar Status do Veículo");
        System.out.println("4 - Buscar Veículos Disponíveis");
        System.out.println("5 - Voltar ao Menu Principal");
        System.out.println("6 - Acessar Menu de Clientes");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
}
