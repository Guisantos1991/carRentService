package domain.interfaces.repository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Optional<domain.entities.Client> findById(Integer id);
    Optional<domain.entities.Client> findByCpf(String cpf);
    List<domain.entities.Client> findByName(String name);
    void save(domain.entities.Client client);
    void deleteById(String id);
}
