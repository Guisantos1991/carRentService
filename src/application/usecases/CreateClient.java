package application.usecases;

import domain.entities.Client;
import domain.interfaces.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class CreateClient {

    List<Client> clients = new ArrayList<Client>();

    Client client;
    public CreateClient(Client client) {
        this.client = client;
    }

    public CreateClient() {
    }

    public CreateClient(List<Client> clients, Client client) {
        this.clients = clients;
        this.client = client;
    }

    public void createClient(Integer id, String name, String cpf, String email, String phone) {
        client = new Client(id, name, cpf, email, phone);
        clients.add(client);
    }

    @Override
    public String toString() {
        return "CreateClient{" + client.getName() + ", " + client.getCpf() + ", " + client.getEmail() + ", " + client.getPhone()+ "}";
    }
}
