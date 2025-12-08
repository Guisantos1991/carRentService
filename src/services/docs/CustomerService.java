package services.docs;

import application.domain.entities.Customer;

import java.util.Optional;

public interface CustomerService {
    void registerCustomer();
    void updateCustomer();
    void activateCustomer();
    void deactivateCustomer();
    Customer findCustomerById(Long id);
    void listAllCustomers();
    void displayCustomerInfo();
    void blockCustomer();
}