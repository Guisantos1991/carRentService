package application.domain.entities;

import application.domain.enums.CustomerStatus;

import java.util.Objects;

public class Customer {
    private final Long id;
    private final String name;
    private final String documentNumber;
    private String email;
    private String phoneNumber;
    private CustomerStatus status;

    public Customer(Long id, String name, String documentNumber, String email, String phoneNumber, CustomerStatus status) {
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }


    public String getDocumentNumber() {
        return documentNumber;
    }



    public String getEmail() {
        return email;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public CustomerStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void activate() {
        this.status = CustomerStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = CustomerStatus.INACTIVE;
    }

    public void block() {
        this.status = CustomerStatus.BLOCKED;
    }

    public Customer orElseThrow(Object clienteNaoEncontrado) {
        return orElseThrow("Cliente não encontrado");
    }
}
