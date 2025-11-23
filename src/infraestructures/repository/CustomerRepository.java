package infraestructures.repository;

import application.domain.entities.Customer;

import java.util.*;

public class CustomerRepository {

    private final Map<Long, Customer> customers = new HashMap<>();

    public Customer save(Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }
}