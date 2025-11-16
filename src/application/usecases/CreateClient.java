package application.usecases;

import domain.entities.Client;
import domain.interfaces.repository.ClientRepository;
import infrastructure.MemoryClientRepository;

import java.util.ArrayList;
import java.util.List;

public class CreateClient {

    private final ClientRepository clientRepository;

    public CreateClient(MemoryClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void execute(int id, String name, String cpf, String email, String phone) {
        clientRepository.save(id, name, cpf, email, phone);
    }

}
