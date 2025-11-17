package application.usecases;

import domain.entities.Client;
import domain.enums.ClientStatus;
import infrastructure.MemoryClientRepository;

import java.util.List;

public class CreateClient {

    public CreateClient() {
    }

    private MemoryClientRepository memoryClientRepository = new MemoryClientRepository();

    public CreateClient(MemoryClientRepository clientRepository) {
        this.memoryClientRepository = clientRepository;
    }

    public void execute(int id, String name, String cpf, String email, String phone, ClientStatus status) {
        memoryClientRepository.save(id, name, cpf, email, phone, status);
    }

    public void executeReturn() {
        List<Client> clients = memoryClientRepository.findAll();

        if (clients.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n=== Lista de Clientes ===");
        for (Client c : clients) {
            System.out.println(c.toString());
        }
        System.out.println("=========================\n");
    }

}
