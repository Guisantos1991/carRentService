package services;

import application.domain.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer registerCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void activateCustomer(Long id);
    void deactivateCustomer(Long id);
    Optional<Customer> findCustomerById(Long id);
    List<Customer> listAllCustomers();
    void displayCustomerInfo(Long id);
}