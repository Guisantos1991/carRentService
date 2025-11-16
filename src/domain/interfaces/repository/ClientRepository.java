package domain.interfaces.repository;

import domain.entities.Client;
import domain.enums.ClientStatus;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Optional<Client> findById(Integer id);
    Optional<Client> findByCpf(String cpf);
    List<Client> findByName(String name);
    void save(int id, String name, String cpf, String email, String phone);

    void save(int id, String name, String cpf, String email, String phone, ClientStatus status);

    void deleteById(String id);
    void updateById(int id, String name, String cpf, String email, String phone);
}
