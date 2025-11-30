package services;

import application.domain.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void registerCustomer();
    void updateCustomer();
    void activateCustomer();
    void deactivateCustomer();
    Optional<Customer> findCustomerById(Long id);
    void listAllCustomers();
    void displayCustomerInfo();
    void blockCustomer();
}