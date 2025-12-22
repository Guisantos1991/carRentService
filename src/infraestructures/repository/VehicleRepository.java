package infraestructures.repository;

import application.domain.entities.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle findByModel(String model) {
        return vehicles.stream().filter(vehicle -> vehicle.getModel().equals(model)).findFirst().orElse(null);
    }

    public Vehicle findById(long id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId() == id).findFirst().orElse(null);
    }

    public List<Vehicle> findAll() {
        return vehicles;
    }
}
