package application.controllers;

import infraestructures.repository.CustomerRepository;
import services.CustomerService;
import services.CustomerServiceImpl;


import java.util.Scanner;

public class CustomerController {

    private final CustomerService customerService;
    private final CliMenuController cliMenuController;
    private final Scanner scanner;

    public CustomerController() {
        CustomerRepository repository = new CustomerRepository();
        this.customerService = new CustomerServiceImpl(repository);
        this.cliMenuController = new CliMenuController();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> customerService.registerCustomer();
                case 2 -> customerService.listAllCustomers();
                case 3 -> customerService.displayCustomerInfo();
                case 4 -> customerService.updateCustomer();
                case 5 -> customerService.activateCustomer();
                case 6 -> customerService.deactivateCustomer();
                case 7 -> customerService.blockCustomer();
                case 8 -> cliMenuController.showMainMenu();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (option != 0);
    }

    private void displayMenu() {
        System.out.println("\n=== MENU DE CLIENTES ===");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Todos os Clientes");
        System.out.println("3 - Buscar Cliente por ID");
        System.out.println("4 - Atualizar Cliente");
        System.out.println("5 - Ativar Cliente");
        System.out.println("6 - Desativar Cliente");
        System.out.println("7 - Bloquear Cliente");
        System.out.println("8 - Voltar ao Menu Principal");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

}