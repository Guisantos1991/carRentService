package application.controllers;

import application.domain.entities.Customer;
import application.domain.enums.CustomerStatus;
import infraestructures.repository.CustomerRepository;
import services.CustomerService;
import services.CustomerServiceImpl;

import java.util.List;
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
                case 1 -> registerCustomer();
                case 2 -> listAllCustomers();
                case 3 -> findCustomerById();
                case 4 -> updateCustomer();
                case 5 -> activateCustomer();
                case 6 -> deactivateCustomer();
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
        System.out.println("7 - Voltar ao Menu Principal");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void registerCustomer() {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");
        System.out.print("ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("CPF/CNPJ: ");
        String documentNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(id, name, documentNumber, email, phoneNumber, CustomerStatus.ACTIVE);
        customerService.registerCustomer(customer);
        System.out.println("✅ Cliente cadastrado com sucesso!");
    }

    private void listAllCustomers() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        List<Customer> customers = customerService.listAllCustomers();

        if (customers.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        customers.forEach(customer -> {
            System.out.println("\nID: " + customer.getId());
            System.out.println("Nome: " + customer.getName());
            System.out.println("CPF/CNPJ: " + customer.getDocumentNumber());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Telefone: " + customer.getPhoneNumber());
            System.out.println("Status: " + customer.getStatus());
            System.out.println("--------------------");
        });
    }

    private void findCustomerById() {
        System.out.print("\nDigite o ID do cliente: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            customerService.displayCustomerInfo(id);
        } catch (RuntimeException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void updateCustomer() {
        System.out.print("\nDigite o ID do cliente a atualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Customer customer = customerService.findCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        System.out.print("Novo Email: ");
        String email = scanner.nextLine();

        System.out.print("Novo Telefone: ");
        String phoneNumber = scanner.nextLine();

        customer.updateContactInfo(email, phoneNumber);
        customerService.updateCustomer(customer);
        System.out.println("✅ Cliente atualizado com sucesso!");
    }

    private void activateCustomer() {
        System.out.print("\nDigite o ID do cliente: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            customerService.activateCustomer(id);
            System.out.println("✅ Cliente ativado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void deactivateCustomer() {
        System.out.print("\nDigite o ID do cliente: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            customerService.deactivateCustomer(id);
            System.out.println("✅ Cliente desativado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}