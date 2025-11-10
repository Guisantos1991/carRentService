package domain.interfaces.repository;

import domain.enums.VehicleStatus;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    Optional<VehicleRepository> findById(Integer id);
    Optional<VehicleRepository> findByPlate(String plate);
    List<VehicleRepository> findAvailableByBranch(Integer branchId);
    Void save(VehicleRepository vehicleRepository);
    Void updateStatus(Integer id, VehicleStatus status);
}
