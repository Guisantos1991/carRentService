package services;

import application.domain.entities.Customer;
import infraestructures.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void activateCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        customer.activate();
        customerRepository.save(customer);
    }

    @Override
    public void deactivateCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        customer.deactivate();
        customerRepository.save(customer);
    }


    public void blockCustomer() {
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
    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void displayCustomerInfo(Long id) {
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
