package infraestructures.repository;

import application.domain.entities.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRepository {
    private final Map<Long, Vehicle> vehicles = new HashMap<>();

    public void save(Long id, Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
        
    }

    public Vehicle findById(long id) {
        return vehicles.get(id);
    }

    public List<Vehicle> findAll() {
        return new ArrayList<>(vehicles.values());
    }
}
