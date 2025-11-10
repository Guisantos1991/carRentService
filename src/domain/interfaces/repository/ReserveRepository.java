package domain.interfaces.repository;

import domain.enums.ReserveStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReserveRepository {
    Optional<ReserveRepository> findById(Integer id);
    List<ReserveRepository> findActiveById(Integer id);
    List<ReserveRepository> findPerPeriod(LocalDate start, LocalDate end);
    Void save(ReserveRepository reserveRepository);
    Void updateStatus(Integer id, ReserveStatus status);
}
