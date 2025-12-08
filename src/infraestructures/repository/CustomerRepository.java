package infraestructures.repository;

import application.domain.entities.Customer;

import java.util.*;

public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public void save(Customer customer) {
        customers.add(customer);
    }

    public Customer findById(Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElseThrow(() -> new NoSuchElementException("Customer not found with ID: " + id));
    }

    public List<Customer> findAll() {
        return customers.stream().toList();
    }
}