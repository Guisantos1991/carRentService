package services;

import application.domain.entities.Customer;
import application.domain.enums.CustomerStatus;
import infraestructures.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

import static java.lang.Long.parseLong;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void registerCustomer() {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");
        System.out.print("ID: ");
        Long id = Long.parseLong(System.console().readLine());


        System.out.print("Nome: ");
        String name = System.console().readLine();

        System.out.print("CPF/CNPJ: ");
        String documentNumber = System.console().readLine();

        System.out.print("Email: ");
        String email = System.console().readLine();

        System.out.print("Telefone: ");
        String phoneNumber = System.console().readLine();

        Customer customer = new Customer(id, name, documentNumber, email, phoneNumber, CustomerStatus.ACTIVE);
        customerRepository.save(customer);
        System.out.println("✅ Cliente cadastrado com sucesso!");
    }

    @Override
    public void updateCustomer() {
        System.out.print("Inform o ID do cliente que será atualizado: ");
        Long id = parseLong(System.console().readLine());
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        System.out.println("\n=== ATUALIZAÇÃO DE CLIENTE ===");
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Nome (" + customer.getName() + "): ");
        String name = System.console().readLine();
        System.out.print("CPF/CNPJ (" + customer.getDocumentNumber() + "): ");
        String documentNumber = System.console().readLine();
        System.out.print("Email (" + customer.getEmail() + "): ");
        String email = System.console().readLine();
        System.out.print("Telefone (" + customer.getPhoneNumber() + "): ");
        String phoneNumber = System.console().readLine();
        Customer updatedCustomer = new Customer(
                customer.getId(),
                name.isEmpty() ? customer.getName() : name,
                documentNumber.isEmpty() ? customer.getDocumentNumber() : documentNumber,
                email.isEmpty() ? customer.getEmail() : email,
                phoneNumber.isEmpty() ? customer.getPhoneNumber() : phoneNumber,
                customer.getStatus()
        );        customerRepository.save(updatedCustomer);
        System.out.println("✅ Cliente atualizado com sucesso!");
    }

    @Override
    public void activateCustomer() {
        System.out.print("Informe o ID que será ativado: ");
        Long id = parseLong(System.console().readLine());
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        customer.activate();
        customerRepository.save(customer);
    }

    @Override
    public void deactivateCustomer() {
        Long id = parseLong(System.console().readLine());
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        customer.deactivate();
        customerRepository.save(customer);
    }


    public void blockCustomer() {
        System.out.print("Digite o Id do cliente: ");
        Long id = parseLong(System.console().readLine());
                Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        customer.block();
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {

        return customerRepository.findById(id);

    }

    @Override
    public void listAllCustomers() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        List<Customer> customers = customerRepository.findAll();

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

    @Override
    public void displayCustomerInfo() {

        System.out.print("Digite o ID do cliente: ");
        Long id = parseLong(System.console().readLine());
        Customer customer = findCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        System.out.println("\n=== INFORMAÇÕES DO CLIENTE ===");
        System.out.println("ID: " + customer.getId());
        System.out.println("Nome: " + customer.getName());
        System.out.println("CPF/CNPJ: " + customer.getDocumentNumber());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Telefone: " + customer.getPhoneNumber());
        System.out.println("Status: " + customer.getStatus());
        System.out.println("=============================");
    }

}
