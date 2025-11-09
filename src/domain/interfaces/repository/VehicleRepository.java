package domain.interfaces.repository;

import domain.entities.Branch;
import domain.entities.Reserve;
import domain.enums.VehicleStatus;

import java.util.List;
import java.util.Optional;

public interface Vehicle {
    Optional<Vehicle> findById(Integer id);
    Optional<Vehicle> findByPlate(String plate);
    List<Vehicle> findAvailableByBranch(Integer branchId);
    Void save(Vehicle vehicle);
    Void updateStatus(Integer id, VehicleStatus status);
}
