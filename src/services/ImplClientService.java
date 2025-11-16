package services;

import domain.entities.Client;
import domain.enums.ClientStatus;
import domain.interfaces.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

public class ImplClientService implements ClientRepository {

    @Override
    public Optional<Client> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findByCpf(String cpf) {
        return Optional.empty();
    }

    @Override
    public List<Client> findByName(String name) {
        return List.of();
    }

    @Override
    public void save(int id, String name, String cpf, String email, String phone) {

    }

    @Override
    public void save(int id, String name, String cpf, String email, String phone, ClientStatus status) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void updateById(int id, String name, String cpf, String email, String phone) {

    }
}
