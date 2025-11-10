package domain.interfaces.repository;

import domain.enums.RentStatus;
import domain.enums.ReserveStatus;

import java.util.Optional;

public interface RentRepository {
    Optional<ReserveRepository> findById(Integer id);
    Void save(ReserveRepository reserveRepository);
    Void updateKilometer(Integer rentId, Long kmFinal);
    Void updateStatus(Integer id, ReserveStatus status, RentStatus rentStatus);
}
