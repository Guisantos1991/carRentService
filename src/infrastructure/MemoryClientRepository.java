package infrastructure;

import domain.entities.Client;
import domain.enums.ClientStatus;
import domain.interfaces.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryClientRepository implements ClientRepository {

    List<Client> clients = new ArrayList<Client>();

    @Override
    public Optional<Client> findById(Integer id) {
        return clients.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Client> findByCpf(String cpf) {
        return clients.stream().filter(c -> c.getCpf().equals(cpf)).findFirst();
    }

    @Override
    public List<Client> findByName(String name) {
        return clients.stream().filter(client -> client.getName().equals(name)).toList();
    }

    @Override
    public void save(int id, String name, String cpf, String email, String phone) {

    }

    @Override
    public void save(int id, String name, String cpf, String email, String phone, ClientStatus status) {
        clients.add(new Client(id, name, cpf, email, phone, status));
    }

    @Override
    public void deleteById(String id) {
        clients.removeIf(c -> c.getId().toString().equals(id));
    }

    @Override
    public void updateById(int id, String name, String cpf, String email, String phone) {
        clients.stream().filter(c -> c.getId().equals(id)).findFirst().ifPresent(c -> {
            c.upDateClient(name, cpf, email, phone);
        });
    }

    @Override
    public Client saveReturn(int id, String name, String cpf, String email, String phone, ClientStatus status) {
        return null;
    }

    public List<Client> findAll() {
        return clients;
    }

}
